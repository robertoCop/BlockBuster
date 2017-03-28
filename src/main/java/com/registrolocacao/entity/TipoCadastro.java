/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registrolocacao.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Roberto_cop
 */
@Entity
@Table(name = "tp_cadastro")
public class TipoCadastro implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id_tipo_cad")
    private Integer idTipo;
    
    @Column(name = "nome_registro")
    private String tipoDeRegistro;

    /**
     * @return the idTipo
     */
    public Integer getIdTipo() {
        return idTipo;
    }

    /**
     * @param idTipo the idTipo to set
     */
    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    /**
     * @return the tipoDeRegistro
     */
    public String getTipoDeRegistro() {
        return tipoDeRegistro;
    }

    /**
     * @param tipoDeRegistro the tipoDeRegistro to set
     */
    public void setTipoDeRegistro(String tipoDeRegistro) {
        this.tipoDeRegistro = tipoDeRegistro;
    }
    
    
}
