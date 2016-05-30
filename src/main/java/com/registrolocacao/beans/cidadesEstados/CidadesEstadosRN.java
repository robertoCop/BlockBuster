package com.registrolocacao.beans.cidadesEstados;

import java.util.List;

import com.registrolocacao.daoFactory.DAOFactory;
import com.registrolocacao.entity.estadoCidade.Cidade;
import com.registrolocacao.entity.estadoCidade.Estado;
import com.registrolocacao.interfaces.cidadesEestados.CidadesEstados;

public class CidadesEstadosRN {
	
	private CidadesEstados inter; 
	
	public CidadesEstadosRN() {
		this.inter = DAOFactory.criarCidadesEstadosImpl();
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
	
	
}
