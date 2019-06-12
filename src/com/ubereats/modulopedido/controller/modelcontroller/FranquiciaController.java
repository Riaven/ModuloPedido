/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;

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
            query = "SELECT * FROM franquicia";
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
                
                for(int i = 0; i < LocalController.listarLocales().size(); i++){
                    if(LocalController.listarLocales().get(i).getIdLocal()==idLocal){
                        Local = LocalController.listarLocales().get(i);
                    }
                }
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
}
