package com.registrolocacao.enums;

public enum ClassificacaoFilmeEnum {

	LIVRE("Livre"), MEDIA_IDADE("+12"),MAIORES("+18");
	
	private String classicacao;
	
	private ClassificacaoFilmeEnum(String tipo) {
		this.classicacao = tipo;
	}

	public String getClassicacao() {
		return classicacao;
	}

	public void setClassicacao(String classicacao) {
		this.classicacao = classicacao;
	}
	
	
	
}
