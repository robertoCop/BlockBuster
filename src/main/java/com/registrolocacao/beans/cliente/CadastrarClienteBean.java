package com.registrolocacao.beans.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.registrolocacao.beans.cidadesEstados.CidadesEstadosRN;
import com.registrolocacao.constants.Constants;
import com.registrolocacao.entity.Cliente;
import com.registrolocacao.entity.Endereco;
import com.registrolocacao.entity.estadoCidade.Cidade;
import com.registrolocacao.entity.estadoCidade.Estado;

@ViewScoped
@ManagedBean(name = "cadastrarClienteBean")
public class CadastrarClienteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String idEstado;
	private Cliente cliente;
	private String cpf;
	private List<Estado> estados = new ArrayList<Estado>();
	private List<Cidade> cidades = new ArrayList<Cidade>();
	
	private boolean campoCidades = false;
	
	public CadastrarClienteBean() {
		cliente =  new Cliente();
	}
	
	@PostConstruct
	public void init(){
		cliente = null;
		cpf = "";
		carregaEstados();
	}
	
	public String salvarCliente(){
		FacesContext context = FacesContext.getCurrentInstance();
		ClienteRN clienteRN = new ClienteRN();
		if(clienteRN.validaClientePorCPF(cliente.getCliCpf())){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Cliente já cadastrado", null));
			return Constants.view.CADASTRO_PAGE;
		}else{
			CidadesEstadosRN cidadeEstRN = new CidadesEstadosRN();
			cliente.getEndereco().setEstado(cidadeEstRN.buscaNomeEstadoPorId(Integer.parseInt(idEstado)));
			clienteRN.salvarCliente(cliente);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente salvo com sucesso", null));
			return Constants.view.CADASTRO_PAGE;
		}
	}
	
	public void carregaEstados(){
		CidadesEstadosRN cidadeEstRN = new CidadesEstadosRN();
		estados = cidadeEstRN.buscarEstados();
	}
	
	public void carregaCidades(){
		if(idEstado != null){
			CidadesEstadosRN cidadeEstRN = new CidadesEstadosRN();
			cidades = cidadeEstRN.buscarCidadePorEstado(Integer.valueOf(idEstado));
			setCampoCidades(false);
		}else{
			setCampoCidades(true);
		}
	}
	
	public Cliente getCliente() {
		if(cliente == null){
			cliente = new Cliente();
			cliente.setEndereco(new Endereco());
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public boolean isCampoCidades() {
		return campoCidades;
	}

	public void setCampoCidades(boolean campoCidades) {
		this.campoCidades = campoCidades;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public String getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

	
}
