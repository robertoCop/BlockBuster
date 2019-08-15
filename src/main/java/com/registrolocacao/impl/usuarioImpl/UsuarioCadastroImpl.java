/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registrolocacao.impl.usuarioImpl;

import com.registrolocacao.conexao.HibernateUtil;
import com.registrolocacao.constants.Constants;
import com.registrolocacao.entity.Usuario;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Roberto_cop
 */

@ManagedBean(name = Constants.beans.USUARIO_BEAN)
@SessionScoped
public class UsuarioCadastroImpl implements Serializable{

	private static final long serialVersionUID = 1L;
	private Session sessao = null;
    private Usuario usuLogado = null;
    
    public void setSession(){
        this.sessao = HibernateUtil.getSessionFactory().openSession();
    }
    
    public Usuario buscarUsuario(String login, String senha) {
        setSession();
        Criteria busca = sessao.createCriteria(Usuario.class);
        busca.add(Restrictions.eq("userLogin", login));
        busca.add(Restrictions.eq("userSenha", senha));
        
        usuLogado = (Usuario)busca.uniqueResult();

        if(usuLogado != null) {
            HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute(Constants.session.USER_SESSION, usuLogado);
        }
        
        return usuLogado;
    }
    
    public String logoffUsusario(){
    	HttpSession sessaoLogada = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    	sessaoLogada.invalidate();
    	return Constants.view.LOGGOFF_PAGE;
    }

    /**
     * @return the usuLogado
     */
    public Usuario getUsuLogado() {
        return usuLogado;
    }

    /**
     * @param usuLogado the usu to set
     */
    public void setUsu(Usuario usuLogado) {
        this.usuLogado = usuLogado;
    }
    
    
}
