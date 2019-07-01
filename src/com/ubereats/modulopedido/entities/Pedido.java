/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Riaven
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido")
    , @NamedQuery(name = "Pedido.findByCantidad", query = "SELECT p FROM Pedido p WHERE p.cantidad = :cantidad")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPedido")
    private Integer idPedido;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado")
    @ManyToOne
    private Estado idEstado;
    @JoinColumn(name = "idCarta", referencedColumnName = "idCarta")
    @ManyToOne
    private Carta idCarta;
    @JoinColumn(name = "idFranquicia", referencedColumnName = "idFranquicia")
    @ManyToOne
    private Franquicia idFranquicia;
    @JoinColumn(name = "idLocal", referencedColumnName = "idLocal")
    @ManyToOne
    private Local idLocal;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(Integer idPedido, int cantidad) {
        this.idPedido = idPedido;
        this.cantidad = cantidad;
    }

    public Pedido(Integer idPedido, int cantidad, Estado idEstado, Carta idCarta, Franquicia idFranquicia, Local idLocal) {
        this.idPedido = idPedido;
        this.cantidad = cantidad;
        this.idEstado = idEstado;
        this.idCarta = idCarta;
        this.idFranquicia = idFranquicia;
        this.idLocal = idLocal;
    }
    
    
    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public Carta getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(Carta idCarta) {
        this.idCarta = idCarta;
    }

    public Franquicia getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(Franquicia idFranquicia) {
        this.idFranquicia = idFranquicia;
    }

    public Local getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Local idLocal) {
        this.idLocal = idLocal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubereats.modulopedido.entities.Pedido[ idPedido=" + idPedido + " ]";
    }
    
}
