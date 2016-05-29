package com.registrolocacao.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.registrolocacao.beans.cliente.CadastrarClienteRN;
import com.registrolocacao.entity.Cliente;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter{
	
	CadastrarClienteRN clienteRN = new CadastrarClienteRN();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value != null && value.trim().length() > 0){
			try{
				return clienteRN.buscaClientePorID(Integer.parseInt(value));
			}catch(NumberFormatException e){
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conversão", null));
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) {
		Cliente cliente = (Cliente)value;
		if(cliente.getCliId() == null){
			return "";
		}else{
			 final Cliente cli =  (Cliente) value;
			 return cli.getCliId().toString();
		}
	}

}
