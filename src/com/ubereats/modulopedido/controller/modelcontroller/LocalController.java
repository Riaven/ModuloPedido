/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;
import com.ubereats.modulopedido.controller.Controlador;
import com.ubereats.modulopedido.model.LocalModel;
import java.sql.Connection;
import java.sql.Statement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/**
 *
 * @author Riaven
 */
public class LocalController{
    //Datos a usar
    private static ArrayList<LocalModel> alLocal = new ArrayList<>();
    private static Connection con = null;
    private static Statement st;
    private static ResultSet rs;
    private static String query;
    //Método que devuelve un array con los locales de la base de datos
    public static ArrayList<LocalModel> listarLocales()throws Exception{
        try{
            con = new Controlador().conectar(); //se crea la instancia para conectar la base de datos
            st = con.createStatement();// crea un statement en la base de datos
            query = "SELECT * FROM local ORDER BY idLocal"; //selecciona todo desde la tabla de local
            rs = st.executeQuery(query);//ejecuta la query y se guarda en rs
            //limpia el array de local
            alLocal.removeAll(alLocal);
            //Examina todos los resultados que devuelve rs
            while(rs.next()){
                int id = rs.getInt("idLocal");
                String menu = rs.getString("menu");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String horario = rs.getString("horario");
                //se añade un nueva instancia cada vez que devuelva resultados rs        
                alLocal.add(new LocalModel(id, menu, direccion, telefono, correo, horario));
            }
            con.close();
        }catch(SQLException sqle){
            //Atrapa el error y lo muestra como mensaje al usuario
            JOptionPane.showMessageDialog(null, "Error SQL : " + sqle);
        }
        //retorna el arrayList de tipo local
        return alLocal;
    }  
    public static LocalModel buscarLocalporCodigo(int codigoLocal)throws Exception{
        LocalModel local = null;
        try{
            con = new Controlador().conectar();
            st = con.createStatement();
            query = "SELECT * FROM local WHERE idLocal = " + codigoLocal;
            rs = st.executeQuery(query);
            rs.next();
             int id = rs.getInt("idLocal");
             String menu = rs.getString("menu");
             String direccion = rs.getString("direccion");
             String telefono = rs.getString("telefono");
             String correo = rs.getString("correo");
             String horario = rs.getString("horario");
             
             local = new LocalModel(id,menu,direccion,telefono,correo,horario);
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error al buscar Local" + sqle);
        }
        return local;    
    }
    
    public static LocalModel buscarLocalporMenu(String menuLocal)throws Exception{
        LocalModel local = null;
        try{
            con = new Controlador().conectar();
            st = con.createStatement();
            query = "SELECT * FROM local WHERE menu = '" + menuLocal + "'";
            rs = st.executeQuery(query);
            rs.next();
             int id = rs.getInt("idLocal");
             String menu = rs.getString("menu");
             String direccion = rs.getString("direccion");
             String telefono = rs.getString("telefono");
             String correo = rs.getString("correo");
             String horario = rs.getString("horario");
             
             local = new LocalModel(id,menu,direccion,telefono,correo,horario);
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error al buscar Local" + sqle);
        }
        return local;    
    }
}
