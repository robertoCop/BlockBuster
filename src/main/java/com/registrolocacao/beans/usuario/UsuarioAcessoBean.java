/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registrolocacao.beans.usuario;

import com.registrolocacao.constants.Constants;
import com.registrolocacao.entity.Usuario;
import com.registrolocacao.impl.usuarioImpl.UsuarioCadastroImpl;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Roberto_cop
 */
@ManagedBean(name = Constants.beans.USUARIO_ACCESS_BEAN)
@RequestScoped
public class UsuarioAcessoBean implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login = "";
    private String senha = "";
    private Usuario usuario = null;
    
    @ManagedProperty("#{usuarioBean}")
    private UsuarioCadastroImpl usu;
    
    public String abrir() throws IOException{
        
        FacesContext msg  = FacesContext.getCurrentInstance();
        if("".equals(this.getLogin()) && "".equals(this.getSenha())){
        	msg.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Favor informar login e senha", ""));
        	return Constants.view.LOGIN_PAGE_REDIRECT;
        }else if("".equals(this.getLogin()) || this.getLogin() == null){
            msg.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Favor informar login",""));
            return Constants.view.LOGIN_PAGE_REDIRECT;
        }else if("".equals(this.getSenha()) || this.getSenha() == null){
            msg.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Favor informar senha",""));
            return Constants.view.LOGIN_PAGE_REDIRECT;
        }else{
            usuario = usu.buscarUsuario(login, senha);
            if(usuario != null){
            	FacesContext.getCurrentInstance().getExternalContext().redirect("X01.jsf");
            }else{
            	msg.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario não cadastrado", ""));
            	return Constants.view.LOGIN_PAGE_REDIRECT;
            }
            
        }     
        return null;
    }
  
    public void cadastrar() throws IOException{
        System.out.println("pagina nova");
        FacesContext.getCurrentInstance().getExternalContext().redirect("X01.jsf");
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usu
     */
    public UsuarioCadastroImpl getUsu() {
        return usu;
    }

    /**
     * @param usu the usu to set
     */
    public void setUsu(UsuarioCadastroImpl usu) {
        this.usu = usu;
    }

    
}
