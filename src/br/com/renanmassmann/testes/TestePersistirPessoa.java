/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.renanmassmann.testes;

import br.com.renanmassmann.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Renan
 */
public class TestePersistirPessoa {
     public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MODELO5");
        EntityManager em = emf.createEntityManager();
        Pessoa e = new Pessoa();
       // e.setId(1);
        e.setNome("Renan");
        e.setCpf("01944165002");
        e.setEmail("renanmassmann@hotmail.com");
        e.setTelefone("54996828448");
        
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        
    }
}


   


