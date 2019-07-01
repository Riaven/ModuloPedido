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
@Table(name = "carta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carta.findAll", query = "SELECT c FROM Carta c")
    , @NamedQuery(name = "Carta.findByIdCarta", query = "SELECT c FROM Carta c WHERE c.idCarta = :idCarta")
    , @NamedQuery(name = "Carta.findByNombre", query = "SELECT c FROM Carta c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Carta.findByDescripcion", query = "SELECT c FROM Carta c WHERE c.descripcion = :descripcion")})
public class Carta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCarta")
    private Integer idCarta;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idFranquicia", referencedColumnName = "idFranquicia")
    @ManyToOne
    private Franquicia idFranquicia;
    @JoinColumn(name = "idLocal", referencedColumnName = "idLocal")
    @ManyToOne
    private Local idLocal;
    @OneToMany(mappedBy = "idCarta")
    private Collection<Pedido> pedidoCollection;

    public Carta() {
    }

    public Carta(Integer idCarta) {
        this.idCarta = idCarta;
    }

    public Carta(Integer idCarta, String nombre, String descripcion) {
        this.idCarta = idCarta;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Carta(Integer idCarta, String nombre, String descripcion, Franquicia idFranquicia, Local idLocal) {
        this.idCarta = idCarta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idFranquicia = idFranquicia;
        this.idLocal = idLocal;
    }

    
    public Integer getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(Integer idCarta) {
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

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarta != null ? idCarta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carta)) {
            return false;
        }
        Carta other = (Carta) object;
        if ((this.idCarta == null && other.idCarta != null) || (this.idCarta != null && !this.idCarta.equals(other.idCarta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubereats.modulopedido.entities.Carta[ idCarta=" + idCarta + " ]";
    }
    
}
