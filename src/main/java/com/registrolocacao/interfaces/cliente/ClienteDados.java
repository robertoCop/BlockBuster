package com.registrolocacao.interfaces.cliente;

import com.registrolocacao.entity.Cliente;

public interface ClienteDados {

	public void salvarCliente(Cliente cli);
	
	public boolean validaCliente(String cpf);
	
	public Cliente buscarCliente(String cpf);
	
	public void excluirCliente(Cliente cli);
	
	
}
