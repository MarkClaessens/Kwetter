package dao;

import domain.Kweet;
import domain.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Mark on 7-3-2017.
 */
@Stateless
public class KweetDAO {

    @PersistenceContext(unitName = "persistence")
    private EntityManager em;

    public List<Kweet> allKweets(){
        return em.createNamedQuery("kweet.all").getResultList();
    }
    public Kweet getKweet(int id){
        Query query = em.createNamedQuery("kweet.getKweet");
        query.setParameter("id", id);
        return (Kweet)query.getSingleResult();
    }

    public void save(Kweet kweet) {
        em.persist(kweet);
    }

    public void delete(Kweet kweet) {em.remove(kweet);}
}
