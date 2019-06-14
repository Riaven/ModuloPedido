/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;
import com.ubereats.modulopedido.model.EstadoModel;
import com.ubereats.modulopedido.controller.Controlador;
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
public class EstadoController {
    private static Connection con = null;
    private static Statement st;
    private static ResultSet rs;
    private static String query;
    private static ArrayList<EstadoModel> alEstado = new ArrayList<>();
    
    //metodo que busca y retorna todo lo de la tabla pedido desde la bd
    public static ArrayList<EstadoModel> listarEstados()throws Exception{
        try{
            con = new Controlador().conectar();
            st = con.createStatement();
            query = "SELECT * FROM estado";
            rs = st.executeQuery(query);
            //Limpiar el array
            alEstado.removeAll(alEstado);
            //guardar los datos del rs  al array
            while(rs.next()){
                int id;
                String descripcion;
                //se asignan los valores que devuelve rs a las variables
                id = rs.getInt("idEstado");
                descripcion = rs.getString("descripcion");
                //crea una instancia y la guarda en el array
                alEstado.add(new EstadoModel(id, descripcion));
            }
            con.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al cargar estado :" + sqle);
        }
        //retorna el array;
        return alEstado;
    }
    //busca un Estado en la base de datos por su id
    public static EstadoModel buscarEstadoPorId(int idEstado)throws Exception{
        //Se crea un objeto de tipo de EstadoModel
        EstadoModel estadito = null;
        try{
        con = new Controlador().conectar();
        st = con.createStatement();
        query = "SELECT * FROM estado WHERE idEstado = " + idEstado;
        rs = st.executeQuery(query);
        rs.next();
        int id = rs.getInt("idEstado");
        String descripcion = rs.getString("descripcion");
        
        estadito =  new EstadoModel(id, descripcion);
        con.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error al buscar estado" + sqle);
        }
        //retorna un objeto ya instanciado de estadoModel
        return estadito;
    }
    //Método que busca un estado en la base de datos para devolver un Objeto de tipo EstadoModel
    public static EstadoModel buscarEstadoPorNombre(String nombreEstado)throws Exception{
        EstadoModel estadito = null;
        try{
        con = new Controlador().conectar();
        st = con.createStatement();
        query = "SELECT * FROM estado WHERE descripcion = '" + nombreEstado + "'";
        rs = st.executeQuery(query);
        rs.next();
        int id = rs.getInt("idEstado");
        String descripcion = rs.getString("descripcion");
        
        estadito =  new EstadoModel(id, descripcion);
        con.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error al buscar estado" + sqle);
        }
        //retorna el objeto ya instanciado de EstadoModel
        return estadito;
    }
}
