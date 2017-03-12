package domain;

import dao.KweetDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Mark on 8-3-2017.
 */


public class KweetTest {


    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("testpersistence");

    private EntityManager em = emf.createEntityManager();

    private User testuser1;
    private User testuser2;
    private User testuser3;
    private Date date;
    private Kweet testkweet1;
    private Kweet testkweet2;
    private Kweet testkweet3;

    @Before
    public void setUp() throws Exception {
        testuser1 = new User("Tom", "mot", new Group());
        date = new Date();
        List<User> mentions1= new ArrayList<>();
        mentions1.add(testuser2);
        mentions1.add(testuser3);
        testkweet1 = new Kweet("hoi",mentions1, date);
        testuser2 = new User("Joep", "peoj",  new Group());
        testkweet2 = new Kweet("Ben",null, date);
        testuser3 = new User("Henk", "kneh",  new Group());
        testkweet3 = new Kweet("Ik",null, date);
    }

    @Test
     public void JPAtest(){
        em.persist(testkweet1);
        System.out.println(em.createNamedQuery("kweet.all").getResultList());
    }

    @Test
    public void getMessage() throws Exception {
        Assert.assertEquals("message incorrect", "hoi", testkweet1.getMessage());
        Assert.assertNotEquals("message correct", "hoi", testkweet2.getMessage());
    }

    @Test
    public void getMentions() throws Exception {
        Assert.assertEquals("message incorrect", 2, testkweet1.getMentions().size());
        Assert.assertNotEquals("mentions correct", 2, testkweet2.getMentions().size());
        Assert.assertEquals("mentions incorrect", 0, testkweet2.getMentions().size());
    }

    @Test
    public void getDate() throws Exception {
        Assert.assertEquals("message incorrect", date, testkweet1.getDate());
        Thread.sleep(1000);
        Assert.assertNotEquals("mentions correct", new Date(), testkweet2.getDate());
        Assert.assertEquals("mentions incorrect", date, testkweet2.getDate());
    }
}