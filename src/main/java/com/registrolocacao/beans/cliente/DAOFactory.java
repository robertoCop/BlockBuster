package com.registrolocacao.beans.cliente;


import org.hibernate.Session;

import com.registrolocacao.conexao.HibernateUtil;
import com.registrolocacao.impl.cidadesEestados.CidadesEstadosImpl;
import com.registrolocacao.impl.clienteImpl.ClienteCadastroImpl;
import com.registrolocacao.interfaces.cidadesEestados.CidadesEstados;
import com.registrolocacao.interfaces.cliente.ClienteDados;
public class DAOFactory {
	
	private static Session sessao;

	/***
	 * Metodo instância a implementação da interface e efetua conexao ao MySql
	 * */
	public static CidadesEstados criarCidadesEstadosImpl(){
		CidadesEstadosImpl impl = new CidadesEstadosImpl();
		sessao = HibernateUtil.getSessionFactory().getCurrentSession();
		if(!sessao.isOpen()){
			impl.setSession(HibernateUtil.getSessionFactory().openSession());
		}else{
			impl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		}
		return impl;
	}
	
	public static ClienteDados cadastrarCliente(){
		ClienteCadastroImpl impl = new ClienteCadastroImpl();
		sessao = HibernateUtil.getSessionFactory().getCurrentSession();
		if(!sessao.isOpen()){
			impl.setSession(HibernateUtil.getSessionFactory().openSession());
		}else{
			impl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		}
		return impl;
	}
}
