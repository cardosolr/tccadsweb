/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.controle;

import br.com.projeto.dao.AlunoDAO;
import br.com.projeto.modelo.Aluno;
import br.com.projeto.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name="controleAluno")
@SessionScoped
public class ControleAluno implements Serializable{
    
   private AlunoDAO dao;
   private Aluno aluno;
    
   public ControleAluno(){
       dao = new AlunoDAO();
   }

   public String listar(){
        return "/paginas/listaraluno?faces-redirect=true";
    }
   
   public String salvar(){
       try{
           dao.salvar(aluno);
           Util.mensagemInformacao(dao.getMensagem());
           return "listaraluno?faces-redirect=true";
       }catch(Exception e){
           e.printStackTrace();
           Util.mensagemErro(dao.getMensagem());
           return "formularioaluno?faces-redirect=true";
       }
    }
   
   public String cancelar(){
        return "listaraluno?faces-redirect=true";
    }
   
   public String editar(Integer id){
        aluno = dao.buscar(id);
        return "formularioaluno?faces-redirect=true";
    }
    
    public void remover(Integer id){
        aluno = dao.buscar(id);
        try{
            dao.deletar(aluno);
            Util.mensagemInformacao(dao.getMensagem());
        }catch(Exception e){
            Util.mensagemErro(dao.getMensagem());
            e.printStackTrace();
        }
    }
    
    public String novo(){
        aluno = new Aluno();
        return "formularioaluno?faces-redirect=true";
    }
   
    public AlunoDAO getDao() {
        return dao;
    }

    public void setDao(AlunoDAO dao) {
        this.dao = dao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
   
}
