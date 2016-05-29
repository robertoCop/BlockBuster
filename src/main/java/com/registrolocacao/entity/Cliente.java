/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registrolocacao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.registrolocacao.enums.TipoCadastroEnum;

/**
 *
 * @author Roberto_cop
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
   
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cli_id")
    private Integer cliId;
    
    @Column(name = "cli_nome", nullable = false, length = 100)
    private String cliNome;
        
    @Column(name = "cli_cpf", length = 20, nullable = false)
    private String cliCpf;
    
    @Column(name = "cli_telefone", nullable = false)
    private String cliTelefone;
    
    @Column(name = "cli_idade", nullable = false)
    private Integer cliIdade;
    
    @Column(name = "cli_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date cliDataNascimento;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    
    @Column(name = "id_tipo_cad")
    @Enumerated
    private TipoCadastroEnum tpCadastro;

    /**
     * @return the cliId
     */
    public Integer getCliId() {
        return cliId;
    }

    /**
     * @param cliId the cliId to set
     */
    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    /**
     * @return the cliNome
     */
    public String getCliNome() {
        return cliNome;
    }

    /**
     * @param cliNome the cliNome to set
     */
    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

     /**
     * @return the cliCpf
     */
    public String getCliCpf() {
        return cliCpf;
    }

    /**
     * @param cliCpf the cliCpf to set
     */
    public void setCliCpf(String cliCpf) {
        this.cliCpf = cliCpf;
    }

    /**
     * @return the cliTelefone
     */
    public String getCliTelefone() {
        return cliTelefone;
    }

    /**
     * @param cliTelefone the cliTelefone to set
     */
    public void setCliTelefone(String cliTelefone) {
        this.cliTelefone = cliTelefone;
    }

    /**
     * @return the cliIdade
     */
    public Integer getCliIdade() {
        return cliIdade;
    }

    /**
     * @param cliIdade the cliIdade to set
     */
    public void setCliIdade(Integer cliIdade) {
        this.cliIdade = cliIdade;
    }

    /**
     * @return the cliDataNascimento
     */
    public Date getCliDataNascimento() {
        return cliDataNascimento;
    }

    /**
     * @param cliDataNascimento the cliDataNascimento to set
     */
    public void setCliDataNascimento(Date cliDataNascimento) {
        this.cliDataNascimento = cliDataNascimento;
    }


    /**
     * @return the tpCadastro
     */
    public TipoCadastroEnum getTpCadastro() {
        return tpCadastro;
    }

    /**
     * @param tpCadastro the tpCadastro to set
     */
    public void setTpCadastro(TipoCadastroEnum tpCadastro) {
        this.tpCadastro = tpCadastro;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
}
