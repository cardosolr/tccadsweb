/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jpa.EntityManagerUtil;
import br.com.projeto.modelo.Curso;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Larissa
 */
public class CursoDAO implements Serializable{
    
    private String mensagem;
    private EntityManager em;
    
    public CursoDAO(){
        em = EntityManagerUtil.getEntityManager();
    }
    
    public List<Curso> getListaCursos(){
        return em.createQuery("FROM Curso ORDER BY nome").getResultList();
    }
    
    public void salvarCurso(Curso c){
        try{
            em.getTransaction().begin();
            if (c.getId() == null){
                em.persist(c);
            } else {
                em.merge(c);
            }
            em.getTransaction().commit();
            mensagem = "Curso salvo com sucesso!";
        }catch(Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            mensagem = "Erro ao salvar o curso";
        }
    }
    
    public void deletarCurso(Curso c){
        try{
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            mensagem = "Curso deletado com sucesso!";
        }catch(Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            mensagem = "Erro ao deletar o curso";
        }
    }
    
    public Curso buscarCurso(Integer id){
        return em.find(Curso.class, id);
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
