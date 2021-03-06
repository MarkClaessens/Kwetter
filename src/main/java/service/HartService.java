package service;

import dao.HartDAO;
import domain.Hart;
import domain.Kweet;
import domain.User;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mark on 7-3-2017.
 */
@Model
public class HartService {

    @Inject
    HartDAO hd;

    /**
     * return all harts
     * @return
     */
    public List<Hart> allharts(){
        return hd.allHarts();
    }

    /**
     * like or dislike a certain kweet with a user
     * @param kweet
     * @param user
     * @return
     */
    public boolean likeDislike(Kweet kweet, User user){
        List<Hart> harts = hd.specificOnKweet(kweet);
        for(Hart hart : harts){
            if(hart.getUser() == user){
                hd.delete(hart);
                return false;
            }
        }
        Hart hart = new Hart(kweet, user);
        hd.save(hart);
        return true;
    }

    /**
     * get all harts on specific kweet
     * @param kweet
     * @return
     */
    public List<Hart> getKweetSpecific(Kweet kweet){
        return hd.specificOnKweet(kweet);
    }

    /**
     * get all harts of specific user
     * @param user
     * @return
     */
    public List<Hart> getUserSpecific(User user){return hd.specificOnUser(user);}

    public void createHart(Kweet kweet, User user){
        Hart hart = new Hart(kweet, user);
        hd.save(hart);
    }
}
