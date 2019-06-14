/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;
import com.ubereats.modulopedido.controller.Controlador;
import com.ubereats.modulopedido.model.CartaModel;
import com.ubereats.modulopedido.model.FranquiciaModel;
import com.ubereats.modulopedido.model.LocalModel;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 *
 * @author Riaven
 */
public class CartaController {
    private static Connection con = null;
    private static String query;
    private static Statement st;
    private static ResultSet rs;
    private static ArrayList<CartaModel> alCarta = new ArrayList<>();
    
    public static ArrayList<CartaModel> listarCartas()throws Exception{
        try{
            con = new Controlador().conectar();
            st = con.createStatement();
            query = "SELECT * FROM carta";
            rs = st.executeQuery(query);
            
            alCarta.removeAll(alCarta);
            
            while(rs.next()){
                int idCarta;
                String nombre;
                String descripcion;
                int idFranquicia;
                int idLocal;
                FranquiciaModel franquicia;
                LocalModel local;
                
                franquicia = null;
                local = null;
                
                idCarta = rs.getInt("idCarta");
                nombre = rs.getString("nombre");
                descripcion = rs.getString("descripcion");
                idFranquicia = rs.getInt("idFranquicia");
                idLocal = rs.getInt("idLocal");
                //obtener Franquicia
                franquicia = FranquiciaController.buscarFranquiciaporCodigo(idFranquicia);
                //para obtener Local
                local = LocalController.buscarLocalporCodigo(idLocal);
                //rellenar el array de carta
                alCarta.add(new CartaModel(idCarta, nombre, descripcion, franquicia, local));
            }
            con.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error listar Carta "+ sqle);
        }
        return alCarta;
    }
    
    public static CartaModel buscarCartaPorId(int idCarta)throws Exception{
        CartaModel carta = null;
        try{
            con = new Controlador().conectar();
            st = con.createStatement();
            query = "SELECT * FROM carta WHERE idCarta = " + idCarta;
            rs = st.executeQuery(query);
            rs.next();
             int id = rs.getInt("idLocal");
             String nombre = rs.getString("nombre");
             String descripcion = rs.getString("descripcion");
             int idFranquicia = rs.getInt("idFranquicia");
             int idLocal = rs.getInt("idLocal");
             
             FranquiciaModel franquicia;
             LocalModel local;
             
             franquicia = FranquiciaController.buscarFranquiciaporCodigo(idFranquicia);
             local = LocalController.buscarLocalporCodigo(idLocal);
             
             carta = new CartaModel(id, nombre, descripcion, franquicia, local);
             con.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error al buscar Carta" + sqle);
        }
        return carta;
    }
    
    public static CartaModel buscarCartaPorNombre(String nombreCarta)throws Exception{
        CartaModel carta = null;
        try{
            con = new Controlador().conectar();
            st = con.createStatement();
            query = "SELECT * FROM carta WHERE nombre = '" + nombreCarta +"'";
            rs = st.executeQuery(query);
            rs.next();
             int id = rs.getInt("idLocal");
             String nombre = rs.getString("nombre");
             String descripcion = rs.getString("descripcion");
             int idFranquicia = rs.getInt("idFranquicia");
             int idLocal = rs.getInt("idLocal");
             
             FranquiciaModel franquicia;
             LocalModel local;
             
             franquicia = FranquiciaController.buscarFranquiciaporCodigo(idFranquicia);
             local = LocalController.buscarLocalporCodigo(idLocal);
             
             carta = new CartaModel(id, nombre, descripcion, franquicia, local);
             con.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error al buscar Carta" + sqle);
        }
        return carta;
    }
}
