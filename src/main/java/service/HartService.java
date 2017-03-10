package service;

import dao.HartDAO;
import domain.Hart;
import domain.Kweet;
import domain.User;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mark on 7-3-2017.
 */
public class HartService {

    @Inject
    HartDAO hd;

    public List<Hart> allharts(){
        return hd.allHarts();
    }

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

    public List<Hart> getKweetSpecific(Kweet kweet){
        return hd.specificOnKweet(kweet);
    }

    public List<Hart> getUserSpecific(Kweet kweet){
        return hd.specificOnKweet(kweet);
    }
}
