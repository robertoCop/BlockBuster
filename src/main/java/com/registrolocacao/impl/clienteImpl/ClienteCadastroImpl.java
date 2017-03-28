package com.registrolocacao.impl.clienteImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.registrolocacao.conexao.HibernateUtil;
import com.registrolocacao.entity.Cliente;
import com.registrolocacao.enums.TipoCadastroEnum;
import com.registrolocacao.interfaces.cliente.ClienteDados;

public class ClienteCadastroImpl implements ClienteDados{
	
	private Session sessao;
	
	public void setSession(Session sessao){
		this.sessao = sessao;
	}
	
	@Override
	public void salvarCliente(Cliente cli) {
		try{
			if(!sessao.isOpen()){
				sessao = HibernateUtil.getSessionFactory().openSession();
			}
			Transaction transaction = sessao.beginTransaction();
			cli.setTpCadastro(TipoCadastroEnum.CLIENTE);
			this.sessao.saveOrUpdate(cli);
			transaction.commit();
		}catch(HibernateException e){
			System.out.println("Erro ao salvar cliente" + e.getMessage());
		}finally{
			if(sessao.isOpen()){
				sessao.close();
			}
		}
	}

	@Override
	public boolean validaCliente(String cpf) {
		try{
			if(!sessao.isOpen()){
				sessao = HibernateUtil.getSessionFactory().openSession();
			}
			Transaction transaction = sessao.beginTransaction();
			Criteria crit = this.sessao.createCriteria(Cliente.class);
			crit.add(Restrictions.eq("cliCpf", cpf));
			final Cliente cliente = (Cliente)crit.uniqueResult();
			transaction.commit();
			if(cliente != null){
				return true;
			}else if(cliente == null){
				return false;
			}
		}catch(HibernateException e){
			System.out.println("Erro ao validar cliente" + e.getMessage());
		}
		return false;
	}

	@Override
	public Cliente buscarCliente(Integer id) {
		try{
			if(!sessao.isOpen()){
				sessao = HibernateUtil.getSessionFactory().openSession();
			}
			Transaction transaction = sessao.beginTransaction();
			Criteria crit = this.sessao.createCriteria(Cliente.class);
			crit.add(Restrictions.eq("cliId", id));
			final Cliente cliente = (Cliente)crit.uniqueResult();
			transaction.commit();
			return cliente;
		}catch(HibernateException e){
			System.out.println("Erro ao buscar cliente"+ e.getMessage());
		}
		return null;
	}

	@Override
	public void excluirCliente(Cliente cli) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscaClientePorCPF(String cpf) {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		try{
			if(!sessao.isOpen()){
				sessao = HibernateUtil.getSessionFactory().openSession();
			}
			Transaction transacao = sessao.beginTransaction();
			Criteria crit = sessao.createCriteria(Cliente.class);
			crit.add(Restrictions.like("cliCpf", cpf + '%'));
			crit.addOrder(Order.asc("cliCpf"));
			listaClientes = crit.list();
			transacao.commit();
		}catch(HibernateException e){
			System.out.println("Erro ao buscar cliente por CPF " + e.getMessage());
		}
		return listaClientes;
	}


}
