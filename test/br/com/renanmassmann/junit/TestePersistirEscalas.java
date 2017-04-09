package br.com.renanmassmann.junit;

import br.com.renanmassmann.modelo.Voo;
import br.com.renanmassmann.modelo.Aeroporto;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
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
public class TestePersistirEscalas {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirEscalas() {
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
            
            Voo voo = em.find(Voo.class, 2);
            Aeroporto a = em.find(Aeroporto.class, 1);
            voo.getEscalas().add(a);
            em.getTransaction().begin();
            em.persist(voo);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        // vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }
    
    
}
