/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.model;

/**
 *
 * @author Riaven
 */
public class CartaModel {
    private int idCarta;
    private String nombre;
    private String descripcion;
    private FranquiciaModel franquicia;
    private LocalModel local;

    public CartaModel() {
    }

    public CartaModel(int idCarta, String nombre, String descripcion, FranquiciaModel franquicia, LocalModel local) {
        this.idCarta = idCarta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.franquicia = franquicia;
        this.local = local;
    }

    public int getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(int idCarta) {
        this.idCarta = idCarta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FranquiciaModel getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(FranquiciaModel franquicia) {
        this.franquicia = franquicia;
    }

    public LocalModel getLocal() {
        return local;
    }

    public void setLocal(LocalModel local) {
        this.local = local;
    }
    
    
    
    
}
