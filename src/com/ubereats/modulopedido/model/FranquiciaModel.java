/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.model;
import com.ubereats.modulopedido.model.LocalModel;
/**
 *
 * @author Riaven
 */
public class FranquiciaModel {
    private int idFranquicia;
    private String nombre;
    private LocalModel local;

    public FranquiciaModel() {
    }

    public FranquiciaModel(int idFranquicia, String nombre, LocalModel local) {
        this.idFranquicia = idFranquicia;
        this.nombre = nombre;
        this.local = local;
    }

    public int getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(int idFranquicia) {
        this.idFranquicia = idFranquicia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalModel getLocal() {
        return local;
    }

    public void setLocal(LocalModel local) {
        this.local = local;
    }
    
    
}
