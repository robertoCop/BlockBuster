package com.registrolocacao.enums;

public enum GeneroFilmeEnum {

	INFANTIL("Infantil"), 
	ACAO("Ação"), 
	AVENTURA("Aventura"), 
	TERROR("Terror"), 
	ROMANCE("Romance"), 
	POLICIAL("Policial"),
	DOCUMENTARIO("Documentario"),
	FICCAO("Ficção");
	
	
	private String tipo;
	
	private GeneroFilmeEnum( String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
