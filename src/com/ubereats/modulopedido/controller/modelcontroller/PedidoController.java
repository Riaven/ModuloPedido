/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;
import com.ubereats.modulopedido.controller.PedidoREST;
import com.ubereats.modulopedido.model.PedidoModel;
import com.ubereats.modulopedido.controller.Controlador;
import com.ubereats.modulopedido.entities.Estado;
import com.ubereats.modulopedido.model.CartaModel;
import com.ubereats.modulopedido.model.EstadoModel;
import com.ubereats.modulopedido.model.FranquiciaModel;
import com.ubereats.modulopedido.model.LocalModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Riaven
 */
public class PedidoController {
    private static PedidoREST pedidoRest = new PedidoREST();
    private static Connection con = null;
    private static Statement st;
    private static ResultSet rs;
    private static String query;
    private static ArrayList<PedidoModel> alPedido = new ArrayList<>();
    //método para poder listar a todos los pedidos existentes en la base de datos
    public static ArrayList<PedidoModel> listarPedidos()throws Exception{
        //Se crea la conexión
        con = new Controlador().conectar();
        st = con.createStatement();
        //query a ejecutar
        query = "SELECT * FROM pedido";
        rs = st.executeQuery(query);
        //Limpiar el array alPedido
        alPedido.removeAll(alPedido);
        //retorna todos los resultados encontrados;
        while(rs.next()){
            //pasa a una variable cada uno de los resultados de cada columna de una fila de la BD
            int idPedido = rs.getInt("idPedido");
            int cantidad = rs.getInt("cantidad");
            int idEstado = rs.getInt("idEstado");
            int idCarta = rs.getInt("idCarta");
            int idFranquicia = rs.getInt("idFranquicia");
            int idLocal = rs.getInt("idLocal");
            //Se crea una instancia de estado segun el id que se rescata desde la bd
            Estado estado = EstadoController.buscarEstadoPorId(idEstado);
            //Se crea una instancia de Carta segun el id que se rescata desde la bd
            CartaModel carta = CartaController.buscarCartaPorId(idCarta);
            //Se crea una instancia de Franquicia segun el id que se rescata desde la bd
            FranquiciaModel franquicia = FranquiciaController.buscarFranquiciaporCodigo(idFranquicia);
            //Se crea una instancia de local segun el id que se rescata desde la bd
            LocalModel local = LocalController.buscarLocalporCodigo(idLocal);
            //se añade al array un nuevo objeto de tipo pedido
            //alPedido.add(new PedidoModel(idPedido, cantidad, estado, carta, franquicia, local));
        }
        //se cierra la base de datos
        con.close();
        //retorna el array de tipo pedido
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
    public static PedidoModel buscarPedidoPorID (int idPedido)throws Exception{
        PedidoModel pedido = null;
        try{
            con = new Controlador().conectar();
            st = con.createStatement();
            query = "SELECT * FROM pedido WHERE idPedido =" + idPedido;
            rs = st.executeQuery(query);
            //obtener los datos que recoge rs
            rs.next();
            int idP = rs.getInt("idPedido");
            int cantidad = rs.getInt("cantidad");
            int idEstado = rs.getInt("idEstado");
            int idCarta = rs.getInt("idCarta");
            int idFranquicia = rs.getInt("idFranquicia");
            int idLocal = rs.getInt("idLocal");
            //Se crea una instancia de estado segun el id que se rescata desde la bd
            Estado estado = EstadoController.buscarEstadoPorId(idEstado);
            //Se crea una instancia de Carta segun el id que se rescata desde la bd
            CartaModel carta = CartaController.buscarCartaPorId(idCarta);
            //Se crea una instancia de Franquicia segun el id que se rescata desde la bd
            FranquiciaModel franquicia = FranquiciaController.buscarFranquiciaporCodigo(idFranquicia);
            //Se crea una instancia de local segun el id que se rescata desde la bd
            LocalModel local = LocalController.buscarLocalporCodigo(idLocal);
            //se crea una nueva instancia al objeto pedido
            //pedido = new PedidoModel(idP, cantidad, estado, carta, franquicia, local);
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error al buscar pedido " + sqle);
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
