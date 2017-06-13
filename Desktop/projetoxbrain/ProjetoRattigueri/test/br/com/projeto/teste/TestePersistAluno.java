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
public class TestePersistAluno {
    
    EntityManager em;
    
    public TestePersistAluno() {
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
            Aluno a = new Aluno();
            a.setNome("Ana");
            a.setRg("54.958.547-9");
            a.setCpf("125.662.225-69");
            a.setEndereco("Rua Getulio, numero 10");
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
