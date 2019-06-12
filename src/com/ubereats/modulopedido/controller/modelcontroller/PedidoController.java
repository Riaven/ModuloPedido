/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;
import com.ubereats.modulopedido.model.PedidoModel;
import com.ubereats.modulopedido.controller.Controlador;
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
    private static Connection con = null;
    private static Statement st;
    private static ResultSet rs;
    private static String query;
    private static ArrayList<PedidoModel> alPedido = new ArrayList<>();
    
    public static ArrayList<PedidoModel> listarPedidos()throws Exception{
        con = new Controlador().conectar();
        st = con.createStatement();
        query = "SELECT * FROM pedido";
        rs = st.executeQuery(query);
        //retorna todos los resultados encontrados;
        while(rs.next()){
            int idPedido = rs.getInt("idPedido");
            int cantidad = rs.getInt("cantidad");
            int idEstado = rs.getInt("idEstado");
            int idCarta = rs.getInt("idCarta");
            int idFranquicia = rs.getInt("idFranquicia");
            int idLocal = rs.getInt("idLocal");
            
            EstadoModel estado = EstadoController.buscarEstadoPorId(idEstado);
            CartaModel carta = CartaController.buscarCartaPorId(idCarta);
            FranquiciaModel franquicia = FranquiciaController.buscarFranquiciaporCodigo(idFranquicia);
            LocalModel local = LocalController.buscarLocalporCodigo(idLocal);
            
            alPedido.add(new PedidoModel(idPedido, cantidad, estado, carta, franquicia, local));
        }
       
        return alPedido;
    }
    
    //metodo para agregar nuevo pedido
    public static int agregarPedido(int idPedido, int cantidad, EstadoModel estado, CartaModel carta, FranquiciaModel franquicia, LocalModel local)throws Exception{
        int filaAgregada = 0;
        try{
            con = new Controlador().conectar();
            st = con.createStatement();
            query = "INSERT INTO pedido VALUES("+ idPedido + ',' +
                                                  cantidad + ',' +
                                                  estado.getIdEstado() + ',' +
                                                  carta.getIdCarta() + ',' +
                                                  franquicia.getIdFranquicia() + ',' +
                                                  local.getIdLocal()  +')';
            filaAgregada = st.executeUpdate(query);
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error al agregar pedido" + estado);
        }
        return filaAgregada;
        
    }
}
