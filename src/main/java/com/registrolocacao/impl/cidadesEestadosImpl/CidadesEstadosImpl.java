package com.registrolocacao.impl.cidadesEestadosImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.registrolocacao.conexao.HibernateUtil;
import com.registrolocacao.entity.estadoCidade.Cidade;
import com.registrolocacao.entity.estadoCidade.Estado;
import com.registrolocacao.interfaces.cidadesEestados.CidadesEstados;

public class CidadesEstadosImpl implements CidadesEstados{
	
	private Session sessao;
	
	public void setSession(Session sessao){
		this.sessao = sessao;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> buscarEstados() {
		List<Estado> listaEstados = new ArrayList<Estado>();
		try{
			if(!sessao.isOpen()){
				sessao = HibernateUtil.getSessionFactory().openSession();
			}
			Transaction transacao = sessao.beginTransaction();
			Criteria crit = sessao.createCriteria(Estado.class);
			listaEstados = crit.list();
			transacao.commit();
		}catch(HibernateException e){
			System.out.println("Erro ao buscar estados" + e.getMessage());
		}
		return listaEstados;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> buscarCidadePorEstado(Integer idEstado) {
		List<Cidade> cidades = new ArrayList<Cidade>();
		try{
			if(!sessao.isOpen()){
				sessao = HibernateUtil.getSessionFactory().openSession();
			}
			Transaction transacao = sessao.beginTransaction();
			Criteria crit = sessao.createCriteria(Cidade.class);
			crit.add(Restrictions.eq("estado.id", idEstado));
			cidades = crit.list();
			transacao.commit();
		}catch(HibernateException e){
			System.out.println("Erro ao buscarCidadePorEstado" + e.getMessage());
		}
		return cidades;
	}

	@Override
	public String buscaNomeEstado(Integer idEstado) {
		String nomeEstado = "";
		try{
			if(!sessao.isOpen()){
				sessao = HibernateUtil.getSessionFactory().openSession();
			}
			Criteria crit = sessao.createCriteria(Estado.class);
			crit.add(Restrictions.eq("id", idEstado));
			final Estado estado = (Estado)crit.uniqueResult();
			nomeEstado = estado.getNomeEstado();
		}catch(HibernateException e){
			System.out.println("Erro ao buscar estado por id " + e.getMessage());
		}
		return nomeEstado;
	}

}
