/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registrolocacao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author Roberto_cop
 */
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{
    
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "cli_id")
	@GeneratedValue(generator = "fk_endereco_cod_cliente")
	@GenericGenerator(name = "fk_endereco_cod_cliente", strategy = "foreign", parameters = {@Parameter(name = "property", value = "cliente")})
    private Integer idEndereco;
    
    @Column(name = "rua", nullable = false, length=100)
    private String rua;
    
    @Column(name = "cidade", nullable = false, length = 50)
    private String cidade;
    
    @Column(name = "estado", nullable = false, length = 10)
    private String estado;
    
    @Column(name = "cep", nullable=false, length = 9)
    private String cep;
     
    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

    /**
     * @return the idEndereco
     */
    public Integer getIdEndereco() {
        return idEndereco;
    }

    /**
     * @param idEndereco the idEndereco to set
     */
    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
