/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Riaven
 */
public class Controlador {
    private Connection conexion = null;
    
    public Controlador(){
        
    }
    //Método para abrir la conexión con la base de datos
    public Connection conectar ()throws Exception{
        try{
            String user = new String("root");//usuario de la base de datos
            String pass = new String("");//contraseña de la base de datos
            String nombreBase = new String("ubereats");//nombre de la base de datos
            String url = "jdbc:mysql://localhost:3306/" + nombreBase;
            Class.forName("com.mysql.jdbc.Drive").newInstance();
            
            conexion = DriverManager.getConnection(url, user, pass);
        }catch (SQLException sqle){
            JOptionPane.showMessageDialog(null, sqle);
        }
        if(conexion != null){
            System.out.println("Se ha establecido correctamente la conexión con la Base de Datos ");
        }
        return conexion;
    }
    //Método para cerrar la conexión con la base de datos
    public void cerrarConexion(){
        try{
            //Comprueba que la base de datos esta conectada
            if(conexion != null){
                //Si es así cierra la conexión
                conexion.close();
            }
        }catch(SQLException sqle){
            //Muestra al usuario error de desconexión
            JOptionPane.showMessageDialog(null, "Problemas al cerrar la base de datos");
        }  
    } 
}
