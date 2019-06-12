/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;
import com.ubereats.modulopedido.model.UsuarioModel;
import com.ubereats.modulopedido.controller.Controlador;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Riaven
 */
public class UsuarioController {
    private static Connection con = null;
    private static Statement st;
    private static ResultSet rs;
    private static String query;
    private static ArrayList<UsuarioModel> alUsuario = new ArrayList<>();
    
    public static ArrayList<UsuarioModel> listarUsuarios()throws Exception{
        try{
            con = new Controlador().conectar();//establece la conexion con la base de datos
            st = con.createStatement();
            query = "SELECT * FROM usuario ORDER BY idUsuario";
            rs = st.executeQuery(query);
            //Se limpia el array de Usuario
            alUsuario.removeAll(alUsuario);
            //rellena el array con los datos que devuelve rs
            while(rs.next()){
                 int idUsuario = rs.getInt("idUsuario");
                 String correo = rs.getString("correo");
                 String telefono = rs.getString("telefono");
                 String contrasenia = rs.getString("contrasenia");
                 String nombre = rs.getString("nombre");
                 String apellido = rs.getString("apellido");
                 //se rellena el array con lo devuelto por rs
                 alUsuario.add(new UsuarioModel(idUsuario, correo, telefono, contrasenia, nombre, apellido));
            }
            con.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error SQL : " + sqle);
        }
        //Retorna el array 
        return alUsuario;
    }
}
