package com.registrolocacao.interfaces.cliente;

import java.util.List;

import com.registrolocacao.entity.Cliente;

public interface ClienteDados {

	public void salvarCliente(Cliente cli);
	
	public boolean validaCliente(String cpf);
	
	public Cliente buscarCliente(Integer id);
	
	public void excluirCliente(Cliente cli);
	
	public List<Cliente> buscaClientePorCPF(String cpf);
}
