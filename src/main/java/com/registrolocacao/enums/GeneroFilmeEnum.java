package com.registrolocacao.enums;

public enum GeneroFilmeEnum {

	INFANTIL("Infantil"), 
	ACAO("A��o"), 
	AVENTURA("Aventura"), 
	TERROR("Terror"), 
	ROMANCE("Romance"), 
	POLICIAL("Policial"),
	DOCUMENTARIO("Documentario"),
	FICCAO("Fic��o");
	
	
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
