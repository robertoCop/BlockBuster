package com.registrolocacao.entity.filme;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.registrolocacao.enums.ClassificacaoFilmeEnum;

@Entity
@Table(name = "filmes")
public class Filmes implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome_filme", nullable = false, length = 30)
	private String nomeFilme;
	
	@OneToOne
	@JoinColumn(name = "idGenero", nullable = false)
	private GeneroFilme genero;
	
	@Column(name = "classificacaoFilme")
	@Enumerated(EnumType.STRING)
	private ClassificacaoFilmeEnum classificacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public GeneroFilme getGenero() {
		return genero;
	}

	public void setGenero(GeneroFilme genero) {
		this.genero = genero;
	}

	public ClassificacaoFilmeEnum getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(ClassificacaoFilmeEnum classificacao) {
		this.classificacao = classificacao;
	}
	
	
	
}
