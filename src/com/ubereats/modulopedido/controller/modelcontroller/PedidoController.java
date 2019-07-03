/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;
import com.ubereats.modulopedido.controller.PedidoREST;
import com.ubereats.modulopedido.entities.Carta;
import com.ubereats.modulopedido.entities.Estado;
import com.ubereats.modulopedido.entities.Franquicia;
import com.ubereats.modulopedido.entities.Local;
import com.ubereats.modulopedido.entities.Pedido;
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
    private static Pedido prueba;
   
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
    public static int agregarPedido(int idPedido, int cantidad, Estado estado, Carta carta, Franquicia franquicia, Local local)throws Exception{
        /**variable que retornara 1 si se agrego correctamente o
         * un 0 (que esta por defecto) si es que la fila no ha sido agregada 
        */
        int filaAgregada = 0;
        pedido = null;
        //try{
            if(buscarPedidoPorID(idPedido)==null){
                //se crea una instancia de pedido
                pedido = new Pedido();
                pedido.setIdPedido(idPedido);
                pedido.setCantidad(cantidad);
                pedido.setIdEstado(estado);
                pedido.setIdCarta(carta);
                pedido.setIdFranquicia(franquicia);
                pedido.setIdLocal(local);
                //pedido = buscarPedidoPorID(4);
                //pedido.setIdPedido(idPedido);
                pedidoRest.create(pedido);
                
                if(buscarPedidoPorID(idPedido)!=null){
                    filaAgregada = 1;
                }
            }else{
                JOptionPane.showMessageDialog(null,"Pedido ya existe");
            }
        //}catch(Exception e){
         //   JOptionPane.showMessageDialog(null,"Error al agregar pedido " + e);
       // }
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
                //metodo del rest que elimina un pedido
                pedidoRest.remove(Integer.toString(idPedido));
                //comprueba nuevamente el id en la base de datos
                if(buscarPedidoPorID(idPedido) == null){
                    //eliminado cambia a 1 ya que ya no existe el pedido en la base de datos
                    eliminado = 1;
                }
            }catch(Exception sqle){
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
            //se sacan los objetos 
            JsonObject objetoEstado = (JsonObject) jsonBuscarPedido.get("idEstado");
            JsonObject objetoLocal = (JsonObject) jsonBuscarPedido.get("idLocal");
            JsonObject objetoFranquicia = (JsonObject) jsonBuscarPedido.get("idFranquicia");
            JsonObject objetoCarta = (JsonObject) jsonBuscarPedido.get("idCarta");
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
            pedido = new Pedido(idPedid, cantidad, estado, carta, franquicia, local);
        }catch(Exception e){
            System.out.println("Error al buscar pedido " + e);
        }
        return pedido;
    }
    //Método para modificar solo el estado de un pedido
    public static int modificarEstadoPedido(String nombreEstado, int idPedido) throws Exception{
        pedido = null;
        //variable que devuelve 1 si el pedido ha sido modificado y 0 si no
        int modificado = 0;
        //se crea una nueva instancia de Estado
        Estado estadoNuevo = null;
        Estado estadoAnterior = null;
        //Se busca el estado que se recibe como parametro un nombre de un estado
        //lo busca y devuelve un objeto tipo EstadoModel
        estadoNuevo = EstadoController.buscarEstadoPorNombre(nombreEstado);
        //Primero se busca para verificar que el pedido existe dentro de la base 
        // de datos
        if(buscarPedidoPorID(idPedido)!=null){
            try{
                pedido = buscarPedidoPorID(idPedido);
                estadoAnterior = pedido.getIdEstado();
                pedido.setIdEstado(estadoNuevo);
                pedidoRest.edit(pedido, Integer.toString(idPedido));
                if(estadoAnterior != buscarPedidoPorID(idPedido).getIdEstado()){
                    modificado = 1;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error al modificar pedido " + e);
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
