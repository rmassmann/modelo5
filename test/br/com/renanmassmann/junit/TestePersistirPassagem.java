package br.com.renanmassmann.junit;

import br.com.renanmassmann.modelo.Classe;
import br.com.renanmassmann.modelo.Passagem;
import br.com.renanmassmann.modelo.Pessoa;
import br.com.renanmassmann.modelo.VooAgendado;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class TestePersistirPassagem {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPassagem() {
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
            Passagem c = new Passagem();
            c.setPessoa(em.find(Pessoa.class, 1));
            c.setBagagem(1);
            c.setClasse(em.find(Classe.class, 1));
            c.setDataCompra(new GregorianCalendar(2016, Calendar.OCTOBER, 25));
            c.setVoo_agendado(em.find(VooAgendado.class, 1));
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
