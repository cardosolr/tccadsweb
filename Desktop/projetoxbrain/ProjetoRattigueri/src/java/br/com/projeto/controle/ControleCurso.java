/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.controle;

import br.com.projeto.dao.CursoDAO;
import br.com.projeto.modelo.Curso;
import br.com.projeto.util.Util;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Larissa
 */
@ManagedBean(name = "controleCurso")
@SessionScoped
public class ControleCurso implements Serializable{
    
    private CursoDAO dao;
    private Curso curso;
    
    public ControleCurso(){
        dao = new CursoDAO();
    }
    
    public String listar(){
        return "/paginas/listarcurso?faces-redirect=true";
    }
    
    public String salvar(){
        try{
            dao.salvarCurso(curso);
            Util.mensagemInformacao(dao.getMensagem());
            return "listarcurso?faces-redirect=true";
        }catch(Exception e){
            e.printStackTrace();
            Util.mensagemErro(dao.getMensagem());
            return "formulariocurso?faces-redirect=true";
        }
    }
    
    public String cancelar(){
        return "listarcurso?faces-redirect=true";
    }

    public String editar(Integer id){
        curso = dao.buscarCurso(id);
        return "formulariocurso?faces-redirect=true";
    }
    
    public void remover(Integer id){
        curso = dao.buscarCurso(id);
        try{
            dao.deletarCurso(curso);
            Util.mensagemInformacao(dao.getMensagem());
        }catch(Exception e){
            e.printStackTrace();
            Util.mensagemErro(dao.getMensagem());
        }
    }
    
    public String novo(){
        curso = new Curso();
        return "formulariocurso?faces-redirect=true";
    }
    
    public CursoDAO getDao() {
        return dao;
    }

    public void setDao(CursoDAO dao) {
        this.dao = dao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
}
