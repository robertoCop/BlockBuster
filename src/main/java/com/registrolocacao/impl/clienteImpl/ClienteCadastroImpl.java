package com.registrolocacao.impl.clienteImpl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
			Transaction transaction = sessao.getTransaction();
			cli.setTpCadastro(TipoCadastroEnum.CLIENTE);
			this.sessao.saveOrUpdate(cli);
			transaction.commit();
		}catch(HibernateException e){
			System.out.println("Erro ao salvar cliente" + e.getMessage());
		}finally{
			sessao.close();
		}
	}

	@Override
	public boolean validaCliente(String cpf) {
		try{
			if(!sessao.isOpen()){
				sessao = HibernateUtil.getSessionFactory().openSession();
			}
			sessao.beginTransaction();
			Criteria crit = this.sessao.createCriteria(Cliente.class);
			crit.add(Restrictions.eq("cliCpf", cpf));
			final Cliente cliente = (Cliente)crit.uniqueResult();
			
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
	public Cliente buscarCliente(String cpf) {
		try{
			if(!sessao.isOpen()){
				sessao = HibernateUtil.getSessionFactory().openSession();
			}
			sessao.beginTransaction();
			Criteria crit = this.sessao.createCriteria(Cliente.class);
			crit.add(Restrictions.eq("cliCpf", cpf));
			final Cliente cliente = (Cliente)crit.uniqueResult();
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


}
