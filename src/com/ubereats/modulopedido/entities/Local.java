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
@Table(name = "local")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Local.findAll", query = "SELECT l FROM Local l")
    , @NamedQuery(name = "Local.findByIdLocal", query = "SELECT l FROM Local l WHERE l.idLocal = :idLocal")
    , @NamedQuery(name = "Local.findByMenu", query = "SELECT l FROM Local l WHERE l.menu = :menu")
    , @NamedQuery(name = "Local.findByDireccion", query = "SELECT l FROM Local l WHERE l.direccion = :direccion")
    , @NamedQuery(name = "Local.findByTelefono", query = "SELECT l FROM Local l WHERE l.telefono = :telefono")
    , @NamedQuery(name = "Local.findByCorreo", query = "SELECT l FROM Local l WHERE l.correo = :correo")
    , @NamedQuery(name = "Local.findByHorario", query = "SELECT l FROM Local l WHERE l.horario = :horario")})
public class Local implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idLocal")
    private Integer idLocal;
    @Basic(optional = false)
    @Column(name = "menu")
    private String menu;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "horario")
    private String horario;
    @OneToMany(mappedBy = "idLocal")
    private Collection<Carta> cartaCollection;
    @OneToMany(mappedBy = "idLocal")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(mappedBy = "idLocal")
    private Collection<Franquicia> franquiciaCollection;

    public Local() {
    }

    public Local(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public Local(Integer idLocal, String menu, String direccion, String telefono, String correo, String horario) {
        this.idLocal = idLocal;
        this.menu = menu;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.horario = horario;
    }

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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

    @XmlTransient
    public Collection<Franquicia> getFranquiciaCollection() {
        return franquiciaCollection;
    }

    public void setFranquiciaCollection(Collection<Franquicia> franquiciaCollection) {
        this.franquiciaCollection = franquiciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocal != null ? idLocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Local)) {
            return false;
        }
        Local other = (Local) object;
        if ((this.idLocal == null && other.idLocal != null) || (this.idLocal != null && !this.idLocal.equals(other.idLocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ubereats.modulopedido.entities.Local[ idLocal=" + idLocal + " ]";
    }
    
}
