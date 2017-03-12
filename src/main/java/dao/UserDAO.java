package dao;

import domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Slashy on 4-3-2017.
 */
@Stateless
public class UserDAO {

    @PersistenceContext(unitName = "persistence")
    private EntityManager em;

    public List<User> allUsers(){
        return em.createNamedQuery("user.all").getResultList();
    }

    public User getUser(String userName){
        Query query = em.createNamedQuery("user.byUserName");
        query.setParameter("userName", userName);
        return (User)query.getSingleResult();

    }
    public List<User> getSpecificFollowing(User user){
        Query query = em.createNamedQuery("user.findfollowing");
        query.setParameter("user", user);
        return query.getResultList();
    }

    public void save(User user) {
        em.persist(user);
    }
}
