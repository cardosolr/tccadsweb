/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Larissa
 */
public class Util {
    
    public static String getMensagemErro(Exception e){
        while(e.getCause() != null){
            e = (Exception) e .getCause();
        }
        String retorno = e.getMessage();
        if (retorno.contains("foreign key")){
            retorno = "Registro não pode ser modificado por causa de chave estrangeira!";
        }
        return retorno;
    }
    
    public static void mensagemInformacao(String msg){
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "");
        fc.addMessage(null, mensagem);
    }
    
    public static void mensagemErro(String msg){
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "");
        fc.addMessage(null, mensagem);
    }
}
