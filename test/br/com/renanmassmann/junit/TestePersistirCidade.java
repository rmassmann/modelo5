package br.com.renanmassmann.junit;

import br.com.renanmassmann.modelo.Cidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorge
 */
public class TestePersistirCidade {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirCidade() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("MODELO5");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();        
    }
    
    @Test
    public void testar(){
        boolean exception = false;
        try {
            Cidade c = new Cidade();
           c.setNome("Cafffoas");
           c.setPais("Brasil");
          
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        // vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }
    
    
}
