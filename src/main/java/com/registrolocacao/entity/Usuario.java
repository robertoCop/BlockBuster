/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registrolocacao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.registrolocacao.enums.TipoCadastroEnum;

/**
 *
 * @author Roberto_cop
 */
@Entity
@Table(name = "usu_sistema")
public class Usuario implements Serializable{
      
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    
    @Column(name = "user_nome", length = 60, nullable = false)
    private String userNome;
    
    @Column(name = "user_cpf", nullable = false, length = 11)
    private String userCpf;
    
    @Column(name = "user_email")
    private String userEmail;
    
    @Column(name = "user_login", nullable = false, length = 15)
    @NaturalId
    private String userLogin;
    
    @Column(name = "user_senha", nullable = false, length = 15)
    private String userSenha;
    
    @Column(name = "id_tipo_cad")
    @Enumerated
    private TipoCadastroEnum tpCadastro;

    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the userNome
     */
    public String getUserNome() {
        return userNome;
    }

    /**
     * @param userNome the userNome to set
     */
    public void setUserNome(String userNome) {
        this.userNome = userNome;
    }

    /**
 
    /**
     * @return the userCpf
     */
    public String getUserCpf() {
        return userCpf;
    }

    /**
     * @param userCpf the userCpf to set
     */
    public void setUserCpf(String userCpf) {
        this.userCpf = userCpf;
    }

      /**
     * @return the userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail the userEmail to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return the userLogin
     */
    public String getUserLogin() {
        return userLogin;
    }

    /**
     * @param userLogin the userLogin to set
     */
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    /**
     * @return the userSenha
     */
    public String getUserSenha() {
        return userSenha;
    }

    /**
     * @param userSenha the userSenha to set
     */
    public void setUserSenha(String userSenha) {
        this.userSenha = userSenha;
    }

	public TipoCadastroEnum getTpCadastro() {
		return tpCadastro;
	}

	public void setTpCadastro(TipoCadastroEnum tpCadastro) {
		this.tpCadastro = tpCadastro;
	}

    /**
     * @return the tpCadastro
     */
    
    
}
