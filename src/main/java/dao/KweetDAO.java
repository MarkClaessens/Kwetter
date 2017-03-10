package dao;

import domain.Kweet;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Mark on 7-3-2017.
 */
@Stateless
public class KweetDAO {

    @Inject
    @PersistenceContext
    EntityManager em;

    public List<Kweet> allKweets(){
        return em.createNamedQuery("Kweet.all").getResultList();
    }

    public void save(Kweet kweet) {
        em.persist(kweet);
    }

    public void delete(Kweet kweet) {em.remove(kweet);}
}
