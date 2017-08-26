/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registrolocacao.conexao;

import com.registrolocacao.constants.Constants;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Roberto_cop
 */
public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY = carregarConexao();

    private static SessionFactory carregarConexao() {
        
        try{
            Configuration config = new Configuration().configure(Constants.conf.HIBERNATE_CONF_XML);
            StandardServiceRegistryBuilder registro = new StandardServiceRegistryBuilder();
            registro.applySettings(config.getProperties()).build();
            StandardServiceRegistry servico = registro.build();
            return config.buildSessionFactory(servico);
        }catch(Throwable e){
            throw new ExceptionInInitializerError(e);
        }
    }
        public static SessionFactory getSessionFactory(){
            return SESSION_FACTORY;
        }
}
