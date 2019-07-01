/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;
import com.ubereats.modulopedido.controller.PedidoREST;
import com.ubereats.modulopedido.model.PedidoModel;
import com.ubereats.modulopedido.controller.Controlador;
import com.ubereats.modulopedido.entities.Carta;
import com.ubereats.modulopedido.entities.Estado;
import com.ubereats.modulopedido.entities.Franquicia;
import com.ubereats.modulopedido.entities.Local;
import com.ubereats.modulopedido.entities.Pedido;
import com.ubereats.modulopedido.model.CartaModel;
import com.ubereats.modulopedido.model.EstadoModel;
import com.ubereats.modulopedido.model.FranquiciaModel;
import com.ubereats.modulopedido.model.LocalModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.swing.JOptionPane;
/**
 *
 * @author Riaven
 */
public class PedidoController {
    private static PedidoREST pedidoRest = new PedidoREST();
    private static Pedido pedido;
     private static ArrayList<Pedido> alPedido = new ArrayList<>();
    
    private static Connection con = null;
    private static Statement st;
    private static ResultSet rs;
    private static String query;
   
    //método para poder listar a todos los pedidos existentes en la base de datos
    public static ArrayList<Pedido> listarPedidos()throws Exception{
        try{
            //crear array tipo json
            JsonArray jsonPedidoArray = Json.createArrayBuilder().build();
            //uso del metodo correspondiente
            jsonPedidoArray = pedidoRest.findAll(JsonArray.class);
            //limpiar array
            alPedido.removeAll(alPedido);
            if(jsonPedidoArray != null){
                int tope = jsonPedidoArray.size();
                for (int i = 0; i < tope; i++){
                    JsonObject objeto = (JsonObject) jsonPedidoArray.get(i);
                    int idPedido = Integer.parseInt(objeto.get("idPedido").toString());
                    int cantidad = Integer.parseInt(objeto.get("cantidad").toString());
                    //se sacan los objetos 
                    JsonObject objetoEstado = (JsonObject) objeto.get("idEstado");
                    JsonObject objetoLocal = (JsonObject) objeto.get("idLocal");
                    JsonObject objetoFranquicia = (JsonObject) objeto.get("idFranquicia");
                    JsonObject objetoCarta = (JsonObject) objeto.get("idCarta");
                    //declaracion e inicializacion de ids
                    int idEstado = 0;
                    int idLocal = 0;
                    int idFranquicia = 0;
                    int idCarta = 0;
                    //otorgar valor real
                    idEstado = Integer.parseInt(objetoEstado.get("idEstado").toString());
                    idLocal = Integer.parseInt(objetoLocal.get("idLocal").toString());
                    idFranquicia = Integer.parseInt(objetoFranquicia.get("idFranquicia").toString());
                    idCarta = Integer.parseInt(objetoCarta.get("idCarta").toString());
                    //declaracion e inicializacion
                    Estado estado = null;
                    Local local = null;
                    Franquicia franquicia = null;
                    Carta carta = null;
                    //consulta por id
                    estado = EstadoController.buscarEstadoPorId(idEstado);
                    local = LocalController.buscarLocalporCodigo(idLocal);
                    franquicia = FranquiciaController.buscarFranquiciaporCodigo(idFranquicia);
                    carta = CartaController.buscarCartaPorId(idCarta);
                    //añade el pedido al array
                    alPedido.add(new Pedido(idPedido, cantidad, estado, carta, franquicia, local));
                }
            }else{
                JOptionPane.showMessageDialog(null,"No se encontraron pedidos en la Base de Datos");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al listar pedidos " + e);
        }
        return alPedido;
    }
    //metodo para agregar nuevo pedido a la bd
    public static int agregarPedido(int idPedido, int cantidad, EstadoModel estado, CartaModel carta, FranquiciaModel franquicia, LocalModel local)throws Exception{
        /**variable que retornara 1 si se agrego correctamente o
         * un 0 (que esta por defecto) si es que la fila no ha sido agregada 
        */
        int filaAgregada = 0;
        try{
            //se crea la conexion con la bd
            con = new Controlador().conectar();
            st = con.createStatement();
            //query más los atributos correspondientes para insertar en la base de datos
            query = "INSERT INTO pedido VALUES("+ idPedido + ',' +
                                                  cantidad + ',' +
                                                  estado.getIdEstado() + ',' +
                                                  carta.getIdCarta() + ',' +
                                                  franquicia.getIdFranquicia() + ',' +
                                                  local.getIdLocal()  +')';
            //filaAgregada toma el numero de filas agregadas que devuelve el st
            filaAgregada = st.executeUpdate(query);
            //se cierra la base de datos
            con.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error al agregar pedido " + sqle);
        }
        //se devuelve el total de filas agregadas
        return filaAgregada;
    }
    //Método para Eliminar un pedido de la base de datos
    public static int eliminarPedido(int idPedido)throws Exception{
        //variable que devuelve 1 si es que se ha eliminado el pedido
        //0 si es que no se ha podido eliminar el pedido
        int eliminado = 0;
        //Se verifica que el pedido exista en la base de datos
        if(buscarPedidoPorID(idPedido)!=null){
            try{
                con = new Controlador().conectar();
                st = con.createStatement();
                //query para eliminar la fila donde el id sea igual 
                //al recibido como parámetro
                query = "DELETE  FROM pedido WHERE idPedido = " +idPedido;
                //la variable encapsulada eliminado capta las filas eliminadas
                eliminado = st.executeUpdate(query);
            }catch(SQLException sqle){
                JOptionPane.showMessageDialog(null,"Error al eliminar pedido " + sqle);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Pedido no existe, no se puede eliminar");
        }
        //retorna la cantidad de filas que fueron eliminadas
        return eliminado;
    }
    //Método para buscar un pedido en específico con su id
    public static Pedido buscarPedidoPorID (int idPedido)throws Exception{
        pedido = null;
        try{
            //objeto json
            JsonObject jsonBuscarPedido = Json.createObjectBuilder().build();
            jsonBuscarPedido = pedidoRest.find(JsonObject.class, Integer.toString(idPedido));
            //parametros
            int idPedid = Integer.parseInt(jsonBuscarPedido.get("idPedido").toString());
            int cantidad  = Integer.parseInt(jsonBuscarPedido.get("cantidad").toString());
            //crea pedido nuevo
            pedido = new Pedido(idPedid,cantidad); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al buscar pedido " + e);
        }
        return pedido;
    }
    //Método para modificar solo el estado de un pedido
    public static int modificarEstadoPedido(String nombreEstado, int idPedido) throws Exception{
        //variable que devuelve 1 si el pedido ha sido modificado y 0 si no
        int modificado = 0;
        //se crea una nueva instancia de EstadoModel
        EstadoModel estado = null;
        //Se busca el estado que se recibe como parametro un nombre de un estado
        //lo busca y devuelve un objeto tipo EstadoModel
       // estado = EstadoController.buscarEstadoPorNombre(nombreEstado);
        //Primero se busca para verificar que el pedido existe dentro de la base 
        // de datos
        if(buscarPedidoPorID(idPedido)!=null){
            try{
                con = new Controlador().conectar();
                st = con.createStatement();
                //query para modificar SOLO EL ESTADO del pedido
                query = "UPDATE pedido " +
                    " SET idEstado ="+ estado.getIdEstado() +
                    " WHERE idPedido = " + idPedido;
                modificado = st.executeUpdate(query);
            }catch(SQLException sqle){
                JOptionPane.showMessageDialog(null,"Error al modificar pedido " + sqle);
            }
        }else{
            // si no existe el pedido dentro de la base de datos se notifica con un msj
            JOptionPane.showMessageDialog(null,"No se puede modificar, el pedido no existe");
        }
        return modificado;
    }
    
    //Metodo para contar pedidos
    public static String contarPedidos(){
        String totalPedidos;
        totalPedidos = "0";
        totalPedidos = pedidoRest.countREST();
        
        return totalPedidos;
    }
}
