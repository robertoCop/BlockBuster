package com.registrolocacao.beans.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.registrolocacao.entity.Cliente;
import com.registrolocacao.entity.estadoCidade.Cidade;
import com.registrolocacao.entity.estadoCidade.Estado;

@ViewScoped
@ManagedBean(name = "alterarClienteBean")
public class AlterarDadosClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String idEstado;
	private CadastrarClienteRN cli = new CadastrarClienteRN();
	private Cliente clienteCadastrado = new Cliente();
	private List<Estado> estados = new ArrayList<Estado>();
	private List<Cidade> cidades = new ArrayList<Cidade>();
	
	private boolean desabilitaCampos = true;
	
	public void ini(){
		carregaEstados();
	}
	
	public void clienteSelecionado(SelectEvent event){
		this.clienteCadastrado =(Cliente) event.getObject();
		carregaEstados();
		carregaCidades();
	}
	
	public List<Cliente> buscaClientePorCpf(String cpf){
		return cli.buscaClientesPorCPf(cpf);
	}

	public void carregaEstados(){
		estados = cli.buscarEstados();
	}
	
	public void carregaCidades(){
		if(idEstado != null){
			cidades = cli.buscarCidadePorEstado(Integer.valueOf(idEstado));
		}
	}
	
	public void salvarAlteracao(){
		FacesContext context = FacesContext.getCurrentInstance();
		this.cli.salvarCliente(clienteCadastrado);
		context.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração salva com sucesso!", ""));
	}
	
	public void cancelarAltaracao(){
		this.clienteCadastrado = null;
	}
	
	public Cliente getClienteCadastrado() {
		return clienteCadastrado;
	}

	public void setClienteCadastrado(Cliente clienteCadastrado) {
		this.clienteCadastrado = clienteCadastrado;
	}


	public String getIdEstado() {
		return idEstado;
	}


	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}


	public CadastrarClienteRN getCli() {
		return cli;
	}


	public void setCli(CadastrarClienteRN cli) {
		this.cli = cli;
	}


	public List<Estado> getEstados() {
		return estados;
	}


	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}


	public List<Cidade> getCidades() {
		return cidades;
	}


	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public boolean isDesabilitaCampos() {
		return desabilitaCampos;
	}

	public void setDesabilitaCampos(boolean desabilitaCampos) {
		this.desabilitaCampos = desabilitaCampos;
	}
	
	

}
