/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registrolocacao.conexao;

import org.hibernate.Session;

/**
 *
 * @author Roberto_cop
 * 
 */
public class TesteConexao {
     public static void main(String[] args) {
        Session sessao = null;
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        System.out.println("*****************CONECTOU BANCO****************");
        sessao.close();
        System.out.println("*****************FECHOU BANCO******************");
    }
}
