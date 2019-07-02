/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.controller.modelcontroller;
import com.ubereats.modulopedido.controller.LocalREST;
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
public class LocalController{
    //Datos a usar
    private static ArrayList<Local> alLocal = new ArrayList<>();
    private static Local local;
    private static LocalREST localRest = new LocalREST();
  
    //Método que devuelve un array con los locales de la base de datos
    public static ArrayList<Local> listarLocales()throws Exception{
        try{
            //Se crea array JSON
            JsonArray jsonLocalArray = Json.createArrayBuilder().build();
            //Se le orotga la info que devuelve findall
            jsonLocalArray = localRest.findAll(JsonArray.class);
            //limpiar array
            alLocal.removeAll(alLocal);
            //comprobar si jsonLocalArray no esta nulo
            if(jsonLocalArray != null){
                int largo = jsonLocalArray.size();
                for(int i = 0; i < largo ; i++){
                    JsonObject objeto = (JsonObject) jsonLocalArray.get(i);
                    //se saca lo que tiene local
                    int idlocal = Integer.parseInt(objeto.get("idLocal").toString());
                    String menu = objeto.get("menu").toString().replace("\"", "");
                    String direccion = objeto.get("direccion").toString().replace("\"", "");
                    String telefono = objeto.get("telefono").toString().replace("\"", "");
                    String correo = objeto.get("correo").toString().replace("\"", "");
                    String horario = objeto.get("horario").toString().replace("\"", "");
                    alLocal.add(new Local(idlocal, menu, direccion, telefono, correo, horario));
                }
            }
            
        }catch(Exception e){
            //Atrapa el error y lo muestra como mensaje al usuario
            JOptionPane.showMessageDialog(null, "Error SQL : " + e);
        }
        //retorna el arrayList de tipo local
        return alLocal;
    }  
    public static Local buscarLocalporCodigo(int codigoLocal)throws Exception{
        local = null;
        try{
            //Se crea un objeto json
            JsonObject jsonBuscarLocal = Json.createObjectBuilder().build();
            jsonBuscarLocal = localRest.find(JsonObject.class, Integer.toString(codigoLocal));
            //rellenando parametros del constructor
            int idLocal = Integer.parseInt(jsonBuscarLocal.get("idLocal").toString());
            String menu = jsonBuscarLocal.get("menu").toString().replace("\"", "");
            String direccion = jsonBuscarLocal.get("direccion").toString().replace("\"", "");
            String telefono = jsonBuscarLocal.get("telefono").toString().replace("\"", "");
            String correo = jsonBuscarLocal.get("correo").toString().replace("\"", "");
            String horario = jsonBuscarLocal.get("horario").toString().replace("\"", "");
            
            local = new Local(idLocal, menu, direccion, telefono, correo, horario);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al buscar Local" + e);
        }
        return local;    
    }
    
    public static Local buscarLocalporMenu(String menuLocal)throws Exception{
        local = null;
        try{
            // se nombra el persistence
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloPedidoPU");
            EntityManager em = emf.createEntityManager();
            //se llama a la query
            TypedQuery<Local> consultaLocal= em.createNamedQuery("Local.findByMenu", Local.class);
            //se cambia el parámetro para hacer la busqueda
            consultaLocal.setParameter("menu", menuLocal);
            
            List<Local> lista= consultaLocal.getResultList();
            
            int idLocal;
            String menu;
            String direccion;
            String telefono;
            String correo;
            String horario;
            //inicializar
            idLocal = 0;
            menu = "";
            direccion  = "";
            telefono = "";
            correo = "";
            horario = "";
            
            for(int i = 0; i < lista.size(); i++){
                idLocal = lista.get(i).getIdLocal();
                menu = lista.get(i).getMenu();
                direccion = lista.get(i).getDireccion();
                telefono = lista.get(i).getTelefono();
                correo = lista.get(i).getCorreo();
                horario = lista.get(i).getHorario();
                local = new Local(idLocal, menu, direccion, telefono, correo, horario);
            }
            
            em.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al buscar Local" + e);
        }
        return local;    
    }
}
