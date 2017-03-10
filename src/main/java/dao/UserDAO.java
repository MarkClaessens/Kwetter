package dao;

import domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Slashy on 4-3-2017.
 */
@Stateless
public class UserDAO {

    @PersistenceContext
    private EntityManager em;

    public List<User> allUsers(){
        return em.createNamedQuery("User.all").getResultList();
    }

    //todo
    public List<User> getSpecificFollowing(User user){
        return null;
    }

    public void save(User user) {
        em.persist(user);
    }
}
