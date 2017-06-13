/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.teste;

import br.com.projeto.jpa.EntityManagerUtil;
import br.com.projeto.modelo.Aluno;
import br.com.projeto.modelo.Curso;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Larissa
 */
public class TestePersistCursoAluno {
    
    EntityManager em;
    
    public TestePersistCursoAluno() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste(){
        boolean ex = false;
        try{
            Aluno a = em.find(Aluno.class, 2);
            Curso c = em.find(Curso.class, 1);
            a.getCursos().add(c);
           
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        }catch(Exception e){
            ex = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false,ex);
        
    }
    
}
