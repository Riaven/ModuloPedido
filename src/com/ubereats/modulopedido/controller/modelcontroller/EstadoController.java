/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;
import com.ubereats.modulopedido.controller.EstadoREST;
import com.ubereats.modulopedido.entities.Estado;
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
public class EstadoController {
    
    private static ArrayList<Estado> alEstado = new ArrayList<>();
    private static Estado estado;
    private static EstadoREST estadoRest = new EstadoREST(); 
    //metodo que busca y retorna todo lo de la tabla pedido desde la bd
    public static ArrayList<Estado> listarEstados()throws Exception{
        try{ 
            //se crea un array Json
            JsonArray jsonEstadoArray = Json.createArrayBuilder().build();
            //se pasa el array que devuelve findAll
            jsonEstadoArray = estadoRest.findAll(JsonArray.class);
            
            //limpiar array
            alEstado.removeAll(alEstado);
            //comprueba que el array json no este nulo
            if(jsonEstadoArray != null){
                
                int tope = jsonEstadoArray.size();
                for(int i = 0; i < tope; i++){
                    //crea un objeto Json para sacar la información
                    JsonObject object = (JsonObject) jsonEstadoArray.get(i);
                    //descripcion 
                    String desc = object.get("descripcion").toString();
                    //int
                    int idEstado = Integer.parseInt(object.get("idEstado").toString());
                    //cambia el formato de "descripcion" y saca las doble comillas
                    String descripcion = desc.replace("\"", "");
                    //se va rellenando el array tipo Estado
                    alEstado.add(new Estado(idEstado, descripcion));
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al cargar estado :" + e);
        }
        //retorna el array;
        return alEstado;
    }
    //busca un Estado en la base de datos por su id
    public static Estado buscarEstadoPorId(int idEstado)throws Exception{
        estado = null;
        try{
         //Construye objeto Json
            JsonObject jsonBuscarEstado = Json.createObjectBuilder().build();
            //hace uso del metodo correspondiente
            jsonBuscarEstado = estadoRest.find(JsonObject.class, Integer.toString(idEstado));

            //descripcion 
            String desc = jsonBuscarEstado.get("descripcion").toString();
            //int
            int idEst = Integer.parseInt(jsonBuscarEstado.get("idEstado").toString());
            String descripcion = desc.replace("\"", "");
            
            estado = new Estado(idEst, descripcion);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al buscar estado" + e);
        }
        //retorna un objeto ya instanciado de estado
        return estado;
    }
    
    //Método que busca un estado en la base de datos para devolver un Objeto de tipo Estado
    public static Estado buscarEstadoPorNombre(String nombreEstado)throws Exception{
        estado = null;
        
        try{
            // se nombra el persistence
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloPedidoPU");
            EntityManager em = emf.createEntityManager();
            //se llama a la query
            TypedQuery<Estado> consultaEstado= em.createNamedQuery("Estado.findByDescripcion", Estado.class);
            //se cambia el parámetro para hacer la busqueda
            consultaEstado.setParameter("descripcion", nombreEstado);
            
            List<Estado> lista= consultaEstado.getResultList();
            
            String desc;
            int idEst;
            
            desc = null;
            idEst = 0;
            
            for(int i = 0; i < lista.size(); i++){
                desc = lista.get(i).getDescripcion();
                idEst = lista.get(i).getIdEstado();
            }
            estado = new Estado(idEst, desc);
            
            em.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al buscar estado " + e);
        }
        return estado;
    }
    
   
    
    
}
