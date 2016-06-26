package com.registrolocacao.entity.filme;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.registrolocacao.enums.GeneroFilmeEnum;

@Entity
@Table(name = "generoFilme")
public class GeneroFilme implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idGenero")
	private Integer id;
	
	@Column(name = "genero")
	@Enumerated(EnumType.STRING)
	private GeneroFilmeEnum tipo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GeneroFilmeEnum getTipo() {
		return tipo;
	}

	public void setTipo(GeneroFilmeEnum tipo) {
		this.tipo = tipo;
	}

	
	
}
