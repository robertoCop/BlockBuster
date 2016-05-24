package com.registrolocacao.entity.estadoCidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "estados")
public class Estado implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	@Column(name = "estadoNome")
	private String nomeEstado;
	
	@Column(name = "estadoSigla")
	private String uf;
	
	@Column(name = "pais")
	private String pais = "BR";
	
	@Transient
	private String estadoNomeEsigla;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstadoNomeEsigla() {
		estadoNomeEsigla = nomeEstado +" - "+ uf;
		return estadoNomeEsigla;
	}

	public void setEstadoNomeEsigla(String estadoNomeEsigla) {
		this.estadoNomeEsigla = estadoNomeEsigla;
	}
	
	
	
}
