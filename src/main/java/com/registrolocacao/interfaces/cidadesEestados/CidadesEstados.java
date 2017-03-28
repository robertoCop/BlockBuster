package com.registrolocacao.interfaces.cidadesEestados;

import java.util.List;

import com.registrolocacao.entity.estadoCidade.Cidade;
import com.registrolocacao.entity.estadoCidade.Estado;

public interface CidadesEstados {

	public List<Estado> buscarEstados();
	
	public List<Cidade> buscarCidadePorEstado(Integer idEstado);
	
	public String buscaNomeEstado(Integer idEstado);
}
