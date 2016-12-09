/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clop.controller;

import com.clop.ejb.PersonaFacadeLocal;
import com.clop.ejb.RolFacadeLocal;
import com.clop.ejb.UsuarioFacadeLocal;
import com.clop.model.Persona;
import com.clop.model.Rol;
import com.clop.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Asus
 */
@Named
@SessionScoped
public class UsuarioController implements Serializable {
    
    @EJB
    private PersonaFacadeLocal personaEJB;
    private UsuarioFacadeLocal usuarioEJB;
    private RolFacadeLocal rolEJB;
    private Persona persona;
    private Usuario usuario;
    private Rol rol;
    
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        persona = new Persona();
        rol = new Rol();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    
    
    
    public void registrar(){
        try{
            this.usuario.setIdPersona(persona);
            usuarioEJB.create(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Se ha registrado correctamente"));
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Se ha registrado correctamente"));
        }
    }
    
    
}  
