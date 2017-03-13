package service;

import dao.KweetDAO;
import domain.Kweet;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mark on 7-3-2017.
 */
@Model
public class KweetService {

    @Inject
    KweetDAO kd;

    /**
     * return all kweets
     * @return
     */
    public List<Kweet> allkweets(){
        return kd.allKweets();
    }

    /**
     * get certain kweet
     * @param id
     * @return
     */
    public Kweet getKweet(int id){return kd.getKweet(id);}

    /**
     * create a kweet
     * @param message
     * @return
     */
    public Kweet createKweet(String message){
        Kweet kweet = new Kweet(message, null, new Date());
        kd.save(kweet);
        return  kweet;
    }

    /**
     * search for certain kweet
     * @param searchtext
     * @return
     */
    public List<Kweet> searchKweet(String searchtext){
        List<Kweet> allKweets = kd.allKweets();
        List<Kweet> kweets = new ArrayList<>();
        for(Kweet kweet : allKweets){
            if(kweet.getMessage().contains(searchtext)){
                kweets.add(kweet);
            }
        }
        return kweets;
    }
}
