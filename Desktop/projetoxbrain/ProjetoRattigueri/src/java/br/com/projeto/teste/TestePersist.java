/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.teste;

import br.com.projeto.modelo.Curso;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProvider;

/**
 *
 * @author Larissa
 */
public class TestePersist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoPU");
        EntityManager em = emf.createEntityManager();
        Curso c = new Curso();
        c.setNome("Java");
        c.setDescricao("Curso de Java");
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
