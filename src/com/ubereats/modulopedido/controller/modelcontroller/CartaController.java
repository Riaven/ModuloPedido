/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;
import com.ubereats.modulopedido.controller.CartaREST;
import com.ubereats.modulopedido.entities.Carta;
import com.ubereats.modulopedido.entities.Franquicia;
import com.ubereats.modulopedido.entities.Local;
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
                    //se captura en jsonobject franquicia y local
                    JsonObject objetoFranquicia = (JsonObject) objeto.get("idFranquicia");
                    JsonObject objetoLocal = (JsonObject) objeto.get("idLocal");
                    //declaracion e inicializacion de id de ambos
                    int idFranquicia = 0;
                    int idLocal = 0;
                    //se obtienen los ids
                    idFranquicia = Integer.parseInt(objetoFranquicia.get("idFranquicia").toString());
                    idLocal = Integer.parseInt(objetoLocal.get("idLocal").toString());
                    //se crean objetos de cada una
                    Local local = null;
                    Franquicia franquicia  = null;
                    //se instancia
                    local = LocalController.buscarLocalporCodigo(idLocal);
                    franquicia = FranquiciaController.buscarFranquiciaporCodigo(idFranquicia);
                    alCarta.add(new Carta(idCarta, nombre, descripcion, franquicia,local));
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
            if(jsonBuscarCarta != null){
                //parámetros
                int idCa =  Integer.parseInt(jsonBuscarCarta.get("idCarta").toString());
                String nombre = jsonBuscarCarta.get("nombre").toString().replace("\"", "");
                String descripcion = jsonBuscarCarta.get("descripcion").toString().replace("\"", "");
                //se captura en jsonobject franquicia y local
                JsonObject objetoFranquicia = (JsonObject) jsonBuscarCarta.get("idFranquicia");
                JsonObject objetoLocal = (JsonObject) jsonBuscarCarta.get("idLocal");
                 //declaracion e inicializacion de id de ambos
                int idFranquicia = 0;
                int idLocal = 0;
                        //se obtienen los ids
                idFranquicia = Integer.parseInt(objetoFranquicia.get("idFranquicia").toString());
                idLocal = Integer.parseInt(objetoLocal.get("idLocal").toString());
                //se crean objetos de cada una
                Local local = null;
                Franquicia franquicia  = null;
                //se instancia
                local = LocalController.buscarLocalporCodigo(idLocal);
                franquicia = FranquiciaController.buscarFranquiciaporCodigo(idFranquicia);
            
                carta = new Carta(idCa, nombre, descripcion, franquicia, local);
            }else{
                JOptionPane.showMessageDialog(null,"No se encontraron cartas en la Base de Datos");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al buscar Carta" + e);
        }
        return carta;
    }
    
    public static Carta buscarCartaPorNombre(String nombreCarta)throws Exception{
        carta = null;
        try{
           // se nombra el persistence
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloPedidoPU");
            EntityManager em = emf.createEntityManager();
            //se llama a la query
            TypedQuery<Carta> consultaCarta= em.createNamedQuery("Carta.findByNombre", Carta.class);
            //se cambia el parámetro para hacer la busqueda
            consultaCarta.setParameter("nombre", nombreCarta);
            
            List<Carta> lista= consultaCarta.getResultList();
            
            int idCa ;
            String nombre;
            String descripcion;
            Franquicia franquicia;
            Local local;
            idCa = 0;
            nombre = null;
            descripcion = null;
            franquicia = null;
            local = null;
            
            for(int i = 0; i < lista.size(); i++){
                idCa = lista.get(i).getIdCarta();
                nombre = lista.get(i).getNombre();
                descripcion = lista.get(i).getDescripcion();
                franquicia = lista.get(i).getIdFranquicia();
                local = lista.get(i).getIdLocal();
                carta = new Carta(idCa, nombre, descripcion, franquicia, local);
            }
            
            em.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al buscar Carta" + e);
        }
        return carta;
    }
}
