package com.registrolocacao.enums;

public enum TipoCadastroEnum {

	USUARIO(1,"USUARIO"),CLIENTE(2,"CLIENTE");
	
	private Integer codigo;
	private String tipoCadastro;
	
	private TipoCadastroEnum(Integer codigo, String tipoCadastro) {
		this.codigo = codigo;
		this.tipoCadastro = tipoCadastro;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipoCadastro() {
		return tipoCadastro;
	}

	public void setTipoCadastro(String tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}
	
	
	
}
