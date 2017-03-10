package dao;

import domain.Hart;
import domain.Kweet;
import domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Mark on 7-3-2017.
 */
@Stateless
public class HartDAO {

    @PersistenceContext
    EntityManager em;

    public List<Hart> allHarts(){
        return em.createNamedQuery("Hart.all").getResultList();
    }
    //todo
    public List<Hart> specificOnKweet(Kweet kweet){
        return null;
    }

    //todo
    public List<Hart> specificOnUser(User user){
        return null;
    }

    public void save(Hart hart){em.persist(hart);}

    public void delete(Hart hart) {em.remove(hart);}
}
