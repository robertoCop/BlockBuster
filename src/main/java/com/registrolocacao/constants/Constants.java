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
        String LOGGOFF_PAGE = "/views/login.xhtml?faces-redirect=true";
    }

    public static interface session{
        String USER_SESSION = "usuario";
    }

    public static interface beans{

        String USUARIO_BEAN = "usuarioBean";
        String USUARIO_ACCESS_BEAN = "usuAcessoBean";
        String USER_ALTER_BEAN = "alterarClienteBean";
        String CAD_CLIENTE_BEAN = "cadastrarClienteBean";
    }

}
