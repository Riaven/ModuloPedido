/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;
import com.ubereats.modulopedido.controller.Controlador;
import com.ubereats.modulopedido.model.CartaModel;
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
                
                idCarta = rs.getInt("idCarta");
                nombre = rs.getString("nombre");
                descripcion = rs.getString("descripcion");
                idFranquicia = rs.getInt("idFranquicia");
                idLocal = rs.getInt("idLocal");
            }
            con.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error listar Carta "+ sqle);
        }
        return alCarta;
    }
}
