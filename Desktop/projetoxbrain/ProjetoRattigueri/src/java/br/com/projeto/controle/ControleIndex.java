/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.controle;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author Larissa
 */
@ManagedBean(name="controleIndex")
public class ControleIndex {
    
    private String mensagem;

    public ControleIndex() {
        mensagem = "Pagina Inicial!!!";
    }
    
    public String cadastroCurso(){
        return "/paginas/listarcurso?faces-redirect=true";
    }
    
    public String mostrarIndex(){
        return "index?faces-redirect=true";
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    
    
}
