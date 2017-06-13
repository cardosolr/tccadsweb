/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jpa.EntityManagerUtil;
import br.com.projeto.modelo.Aluno;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Larissa
 */
public class AlunoDAO {
    
    private String mensagem;
    private EntityManager em;
    
    public AlunoDAO(){
        em = EntityManagerUtil.getEntityManager();
    }
    
    public List<Aluno> getLista(){
        return em.createQuery("FROM Aluno ORDER BY nome").getResultList();
    }
    
    public void salvar(Aluno a){
        try{
            em.getTransaction().begin();
            if (a.getId() == null){
                em.persist(a);
            } else {
                em.merge(a);
            }
            em.getTransaction().commit();
            mensagem = "Aluno salvo com sucesso!";
        }catch(Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            mensagem = "Erro ao salvar o aluno";
        }
    }
    
    public void deletar(Aluno a){
        try{
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
            mensagem = "Aluno deletado com sucesso!";
        }catch(Exception e){
            if (em.getTransaction().isActive() == false){
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            mensagem = "Erro ao deletar o aluno";
        }
    }
    
    public Aluno buscar(Integer id){
        return em.find(Aluno.class, id);
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
