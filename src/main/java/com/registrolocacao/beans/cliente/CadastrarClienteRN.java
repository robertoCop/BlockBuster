package com.registrolocacao.beans.cliente;

import java.util.List;

import com.registrolocacao.entity.Cliente;
import com.registrolocacao.entity.estadoCidade.Cidade;
import com.registrolocacao.entity.estadoCidade.Estado;
import com.registrolocacao.interfaces.cidadesEestados.CidadesEstados;
import com.registrolocacao.interfaces.cliente.ClienteDados;

public class CadastrarClienteRN {
	
	private CidadesEstados inter; 
	
	private ClienteDados cli;
	
	
	public CadastrarClienteRN() {
		this.inter = DAOFactory.criarCidadesEstadosImpl();
		this.cli = DAOFactory.cadastrarCliente();
	}
	
	public List<Estado> buscarEstados(){
		return this.inter.buscarEstados();
	}
	
	public List<Cidade> buscarCidadePorEstado(Integer idEstado){
		return this.inter.buscarCidadePorEstado(idEstado);
	}
	
	public String buscaNomeEstadoPorId(Integer idEstado){
		return this.inter.buscaNomeEstado(idEstado);
	}
	
	public void salvarCliente(Cliente cli){
		this.cli.salvarCliente(cli);
	}
	
	public boolean validaClientePorCPF(String cpf){
		return this.cli.validaCliente(cpf);
	}
}
