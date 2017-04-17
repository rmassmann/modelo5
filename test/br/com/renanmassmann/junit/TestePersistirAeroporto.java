package br.com.renanmassmann.junit;

import br.com.renanmassmann.modelo.Aeroporto;
import br.com.renanmassmann.modelo.Cidade;
import br.com.renanmassmann.modelo.Voo;
import java.util.ArrayList;
import java.util.List;
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
public class TestePersistirAeroporto {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirAeroporto() {
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
            Aeroporto c = new Aeroporto();
            //List<Voo> voos = new ArrayList<>();
            //voos.add(em.find(Voo.class, 1));
           // c.setId(2);
            c.setNome("Aeroporto rio");
            c.setOperacional(true);
            c.setCidade(em.find(Cidade.class, 1));
            //.setVoos(voos);
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
