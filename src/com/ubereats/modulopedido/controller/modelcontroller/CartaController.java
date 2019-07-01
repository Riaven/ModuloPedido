/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;
import com.ubereats.modulopedido.controller.CartaREST;
import com.ubereats.modulopedido.controller.Controlador;
import com.ubereats.modulopedido.entities.Carta;
import com.ubereats.modulopedido.model.CartaModel;
import com.ubereats.modulopedido.model.FranquiciaModel;
import com.ubereats.modulopedido.model.LocalModel;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.swing.JOptionPane;
/**
 *
 * @author Riaven
 */
public class CartaController {
    private static ArrayList<Carta> alCarta = new ArrayList<>();
    private static Carta carta;
    private static CartaREST cartaRest = new CartaREST();
    //método para listar cartas
    public static ArrayList<Carta> listarCartas()throws Exception{
        try{
            JsonArray jsonCartaArray = Json.createArrayBuilder().build();
            //llega info
            jsonCartaArray = cartaRest.findAll(JsonArray.class);
            //limpiar
            alCarta.removeAll(alCarta);
            if(jsonCartaArray != null){
                int tope = jsonCartaArray.size();
                for(int i = 0; i < tope; i++ ){
                    JsonObject objeto = (JsonObject) jsonCartaArray.get(i);
                    //parametros necesarios
                    int idCarta =  Integer.parseInt(objeto.get("idCarta").toString());
                    String nombre = objeto.get("nombre").toString().replace("\"", "");
                    String descripcion = objeto.get("descripcion").toString().replace("\"", "");
                    alCarta.add(new Carta(idCarta, nombre, descripcion));
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error listar Carta "+ e);
        }
        return alCarta;
    }
    
    public static Carta buscarCartaPorId(int idCarta)throws Exception{
        carta = null;
        try{
            JsonObject jsonBuscarCarta = Json.createObjectBuilder().build();
            //método a necesitar
            jsonBuscarCarta = cartaRest.find(JsonObject.class, Integer.toString(idCarta));
            //parámetros
            int idCa =  Integer.parseInt(jsonBuscarCarta.get("idCarta").toString());
            String nombre = jsonBuscarCarta.get("nombre").toString().replace("\"", "");
            String descripcion = jsonBuscarCarta.get("descripcion").toString().replace("\"", "");
            
            carta = new Carta(idCa, nombre, descripcion);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al buscar Carta" + e);
        }
        return carta;
    }
    
    public static Carta buscarCartaPorNombre(String nombreCarta)throws Exception{
        carta = null;
        try{
           //porhacer
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al buscar Carta" + e);
        }
        return carta;
    }
}
