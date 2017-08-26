package com.registrolocacao.constants;

public class Constants {


    public static interface conf{

        String HIBERNATE_CONF_XML = "hibernate.cfg.xml";

    }

    public static interface view{

        String LOGIN_PAGE = "/views/login.jsf";
        String LOGIN_REDIRECT = "login.jsf";
        String LOGIN_PAGE_REDIRECT = "login.xhtml?faces-redirect=true";
        String CADASTRO_PAGE = "cadastroCliente";

    }

}
