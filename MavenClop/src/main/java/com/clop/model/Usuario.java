/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clop.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name="tbl_usuario")
public class Usuario implements Serializable{
    
    @Id
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_Persona", nullable = false)
    private Persona idPersona;
    
    @Column(name="Usu_Login")
    private String login;
    
    @Column(name="Usu_Clave")
    private String clave;
    
    @ManyToOne
    @JoinColumn(name = "Usu_Rol",nullable = false)
    private Rol rol;
    
    @Column(name="Estado")
    private short estado = 1;

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.idPersona);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.idPersona, other.idPersona)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idPersona=" + idPersona + '}';
    }
    
    
}
