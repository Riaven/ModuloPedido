/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;
//Paquetes necesarios
import com.ubereats.modulopedido.controller.Controlador;
import com.ubereats.modulopedido.model.FranquiciaModel;
import com.ubereats.modulopedido.model.LocalModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Riaven
 */
public class FranquiciaController {
    private static Connection con = null;
    private static Statement st;
    private static ResultSet rs;
    private static String query;
    private static ArrayList<FranquiciaModel> alFranquicia = new ArrayList<>();
    //metodo que busca y retorna todo lo de la tabla pedido desde la bd
    public static ArrayList<FranquiciaModel> listarFranquicias()throws Exception{
        try{
            con = new Controlador().conectar();
            st = con.createStatement();
            query = "SELECT * FROM franquicia ";
            rs = st.executeQuery(query);
            //Limpiar el array
            alFranquicia.removeAll(alFranquicia);
            //guardar los datos del rs  al array
            while(rs.next()){
                int idFranquicia;
                String nombre;
                LocalModel Local = null;
                int idLocal;
                //se asignan los valores que devuelve rs a las variables
                idFranquicia = rs.getInt("idFranquicia");
                nombre = rs.getString("nombre");
                idLocal = rs.getInt("idLocal");
                
                Local = LocalController.buscarLocalporCodigo(idLocal);
                
                //crea una instancia y la guarda en el array
                alFranquicia.add(new FranquiciaModel(idFranquicia, nombre, Local));
            }
            con.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null, "Error al cargar estado :" + sqle);
        }
        //retorna el array;
        return alFranquicia;
    }
    //Método que busca una Franquicia en la base de datos por su código
    public static FranquiciaModel buscarFranquiciaporCodigo(int codigoFranquicia)throws Exception{
        //se crea una variable de tipo FranquiciaModel y se inicializa como null
        FranquiciaModel franquicia = null;
        try{
            con = new Controlador().conectar();
            st = con.createStatement();
            query = "SELECT * FROM franquicia WHERE idFranquicia = " + codigoFranquicia;
            rs = st.executeQuery(query);
            //obtiene el siguiente resultado
            rs.next();
            int id = rs.getInt("idFranquicia");
            String nombre = rs.getString("nombre");
            int idLocal = rs.getInt("idLocal");
            //se crea un objeto de tipo Local
            LocalModel local;
            //se busca el local obtenido por el código del mismo
            local =  LocalController.buscarLocalporCodigo(idLocal);
             // se crea una nueva instancia de FranquiciaModel con los datos obtenidos
            franquicia = new FranquiciaModel(id, nombre, local);
            con.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error al buscar Local" + sqle);
        }
        //retorna el objeto de tipo franquiciaModel
        return franquicia;    
    }
    /**
     * Método que busca una Franquicia en la base de datos  por su nombre 
     */
    public static FranquiciaModel buscarFranquiciaporNombre(String nombreFranquicia)throws Exception{
        FranquiciaModel franquicia = null;
        try{
            con = new Controlador().conectar();
            st = con.createStatement();
            //se deben de poner comillas simples al comparar un String o Varchar
            query = "SELECT * FROM franquicia WHERE nombre = '" + nombreFranquicia + "'";
            rs = st.executeQuery(query);
            //obtiene el siguiente resultado
            rs.next();
            //capta el id, nombre e idLocal
            int id = rs.getInt("idFranquicia");
            String nombre = rs.getString("nombre");
            int idLocal = rs.getInt("idLocal");
            //se crea un nuevo objeto de tipo LocalModel
            LocalModel local;
            //se rellena el objeto con el que devuelve el método buscarLocalPorCodigo
            local =  LocalController.buscarLocalporCodigo(idLocal);
             //se crea una nueva instancia de FranquiciaModel con los datos obtenidos
            franquicia = new FranquiciaModel(id, nombre, local);
            //se cierra la conexion con la base de datos
            con.close();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(null,"Error al buscar Local" + sqle);
        }
        //se retorna el objeto de tipo FranquiciaModel
        return franquicia;    
    }
}