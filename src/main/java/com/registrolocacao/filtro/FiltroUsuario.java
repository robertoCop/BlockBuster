package com.registrolocacao.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import com.registrolocacao.conexao.HibernateUtil;
import com.registrolocacao.entity.Usuario;

public class FiltroUsuario implements Filter{
	
	@SuppressWarnings("unused")
	private SessionFactory factory;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpSession httpSession = ((HttpServletRequest)request).getSession(true);
		
		HttpServletResponse httpServletResponse = ((HttpServletResponse)response);
		
		String paginaCorrente = ((HttpServletRequest)request).getServletPath();
		
		String paginaLogin = "/views/login.jsf";
		
		final Usuario usuLogado = (Usuario)httpSession.getAttribute("usuario");

		if(!paginaCorrente.contains(paginaLogin)){
			if(usuLogado == null){
				httpServletResponse.sendRedirect("login.jsf");
			}else{
				chain.doFilter(request, response);
			}
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.factory = HibernateUtil.getSessionFactory();
	}

}
