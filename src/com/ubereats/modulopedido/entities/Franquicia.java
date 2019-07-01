/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubereats.modulopedido.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Riaven
 */
@Entity
@Table(name = "franquicia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Franquicia.findAll", query = "SELECT f FROM Franquicia f")
    , @NamedQuery(name = "Franquicia.findByIdFranquicia", query = "SELECT f FROM Franquicia f WHERE f.idFranquicia = :idFranquicia")
    , @NamedQuery(name = "Franquicia.findByNombre", query = "SELECT f FROM Franquicia f WHERE f.nombre = :nombre")})
public class Franquicia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idFranquicia")
    private Integer idFranquicia;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idFranquicia")
    private Collection<Carta> cartaCollection;
    @OneToMany(mappedBy = "idFranquicia")
    private Collection<Pedido> pedidoCollection;
    @JoinColumn(name = "idLocal", referencedColumnName = "idLocal")
    @ManyToOne
    private Local idLocal;

    public Franquicia() {
    }

    public Franquicia(Integer idFranquicia) {
        this.idFranquicia = idFranquicia;
    }

    public Franquicia(Integer idFranquicia, String nombre) {
        this.idFranquicia = idFranquicia;
        this.nombre = nombre;
    }

    public Franquicia(Integer idFranquicia, String nombre, Local idLocal) {
        this.idFranquicia = idFranquicia;
        this.nombre = nombre;
        this.idLocal = idLocal;
    }

    
    
    public Integer getIdFranquicia() {
        return idFranquicia;
    }

    public void setIdFranquicia(Integer idFranquicia) {
        this.idFranquicia = idFranquicia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Carta> getCartaCollection() {
        return cartaCollection;
    }

    public void setCartaCollection(Collection<Carta> cartaCollection) {
        this.cartaCollection = cartaCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
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
        hash += (idFranquicia != null ? idFranquicia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Franquicia)) {
            return false;
        }
        Franquicia other = (Franquicia) object;
        if ((this.idFranquicia == null && other.idFranquicia != null) || (this.idFranquicia != null && !this.idFranquicia.equals(other.idFranquicia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubereats.modulopedido.entities.Franquicia[ idFranquicia=" + idFranquicia + " ]";
    }
    
}
