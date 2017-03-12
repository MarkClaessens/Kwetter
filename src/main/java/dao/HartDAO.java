package dao;

import domain.Hart;
import domain.Kweet;
import domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Mark on 7-3-2017.
 */
@Stateless
public class HartDAO {

    @PersistenceContext(unitName = "persistence")
    private EntityManager em;

    public List<Hart> allHarts(){
        return em.createNamedQuery("hart.all").getResultList();
    }

    public List<Hart> specificOnKweet(Kweet kweet){
        Query query = em.createNamedQuery("hart.findbykweet");
        query.setParameter("kweet", kweet);
        return query.getResultList();
    }


    public List<Hart> specificOnUser(User user){
        Query query = em.createNamedQuery("hart.findbyuser");
        query.setParameter("user", user);
        return query.getResultList();
    }

    public void save(Hart hart){em.persist(hart);}

    public void delete(Hart hart) {em.remove(hart);}
}
