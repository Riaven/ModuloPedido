/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;
//Paquetes necesarios
import com.ubereats.modulopedido.controller.FranquiciaREST;
import com.ubereats.modulopedido.entities.Franquicia;
import com.ubereats.modulopedido.model.FranquiciaModel;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author Riaven
 */
public class FranquiciaController {
    private static ArrayList<Franquicia> alFranquicia = new ArrayList<Franquicia>();
    private static Franquicia franquicia;
    private static FranquiciaREST franquiciaRest = new FranquiciaREST();
    
    
    //metodo que busca y retorna todo lo de la tabla pedido desde la bd
    public static ArrayList<Franquicia> listarFranquicias()throws Exception{
        try{
            JsonArray jsonFranquiciaArray = Json.createArrayBuilder().build();
            //se le otorga la info
            jsonFranquiciaArray = franquiciaRest.findAll(JsonArray.class);
            //limpia el array
            alFranquicia.removeAll(alFranquicia);
            //Comprobar que el JsonArray no este vacío
            if(jsonFranquiciaArray != null){
                int tope = jsonFranquiciaArray.size();
                //para recorreo el array
                for(int i = 0; i < tope; i++){
                    JsonObject objeto = (JsonObject) jsonFranquiciaArray.get(i);
                    //info
                    int idFranquicia = Integer.parseInt(objeto.get("idFranquicia").toString());
                    String nombre = objeto.get("nombre").toString().replace("\"", "");
                    //rellenar el array
                    alFranquicia.add(new Franquicia(idFranquicia, nombre));                 
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al cargar estado :" + e);
        }
        //retorna el array;
        return alFranquicia;
    }
    //Método que busca una Franquicia en la base de datos por su código
    public static Franquicia buscarFranquiciaporCodigo(int codigoFranquicia)throws Exception{
        franquicia = null;
        try{
            JsonObject jsonBuscarCodigo = Json.createObjectBuilder().build();
            //se hace uso del metodo correspondiente
            jsonBuscarCodigo = franquiciaRest.find(JsonObject.class, Integer.toString(codigoFranquicia));
            
            int idFranquicia = Integer.parseInt(jsonBuscarCodigo.get("idFranquicia").toString());
            String nombre = jsonBuscarCodigo.get("nombre").toString().replace("\"", "");
            
            franquicia = new Franquicia(idFranquicia, nombre);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al buscar Local" + e);
        }
        //retorna el objeto de tipo franquiciaModel
        return franquicia;    
    }
    /**
     * Método que busca una Franquicia en la base de datos  por su nombre 
     */
    public static Franquicia buscarFranquiciaporNombre(String nombreFranquicia)throws Exception{
        franquicia = null;
        try{
             // se nombra el persistence
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloPedidoPU");
            EntityManager em = emf.createEntityManager();
            //se llama a la query
            TypedQuery<Franquicia> consultaEstado= em.createNamedQuery("Franquicia.findByNombre", Franquicia.class);
            //se cambia el parámetro para hacer la busqueda
            consultaEstado.setParameter("nombre", nombreFranquicia);
            
            List<Franquicia> lista= consultaEstado.getResultList();
            int idFranquicia;
            String nombre;
            
            idFranquicia = 0;
            nombre = "";
            
            for(int i = 0; i < lista.size(); i++){
                idFranquicia = lista.get(i).getIdFranquicia();
                nombre = lista.get(i).getNombre();
            }
            franquicia = new Franquicia(idFranquicia, nombre);
            em.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al buscar Local" + e);
        }
        //se retorna el objeto de tipo FranquiciaModel
        return franquicia;    
    }
}
