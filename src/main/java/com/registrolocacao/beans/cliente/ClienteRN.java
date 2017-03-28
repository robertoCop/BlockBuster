package com.registrolocacao.beans.cliente;

import java.util.List;

import com.registrolocacao.daoFactory.DAOFactory;
import com.registrolocacao.entity.Cliente;
import com.registrolocacao.interfaces.cliente.ClienteDados;

public class ClienteRN {
	
	
	private ClienteDados cli;
	
	public ClienteRN() {
		this.cli = DAOFactory.criarClienteImpl();
	}
	
	public void salvarCliente(Cliente cli){
		this.cli.salvarCliente(cli);
	}
	
	public boolean validaClientePorCPF(String cpf){
		return this.cli.validaCliente(cpf);
	}
	
	public List<Cliente> buscaClientesPorCPf(String cpf){
		return this.cli.buscaClientePorCPF(cpf);
	}
	
	public Cliente buscaClientePorID(Integer id){
		return this.cli.buscarCliente(id);
	}
}
