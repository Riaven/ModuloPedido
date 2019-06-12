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
public class PedidoModel {
    private int idPedido;
    private int cantidad;
    private EstadoModel estado;
    private CartaModel carta;
    private FranquiciaModel franquicia;
    private LocalModel local;

    public PedidoModel() {
    }

    public PedidoModel(int idPedido, int cantidad, EstadoModel estado, CartaModel carta, FranquiciaModel franquicia, LocalModel local) {
        this.idPedido = idPedido;
        this.cantidad = cantidad;
        this.estado = estado;
        this.carta = carta;
        this.franquicia = franquicia;
        this.local = local;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public EstadoModel getEstado() {
        return estado;
    }

    public void setEstado(EstadoModel estado) {
        this.estado = estado;
    }

    public CartaModel getCarta() {
        return carta;
    }

    public void setCarta(CartaModel carta) {
        this.carta = carta;
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
