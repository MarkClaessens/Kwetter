package service;

import dao.KweetDAO;
import domain.Kweet;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mark on 7-3-2017.
 */
public class KweetService {

    @Inject
    KweetDAO kd;

    public List<Kweet> allkweets(){
        return kd.allKweets();
    }

    //todo get mentions out of message? or add way to mention people
    public Kweet createKweet(String message){
        Kweet kweet = new Kweet(message, null, new Date());
        kd.save(kweet);
        return  kweet;
    }

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

    public void deleteKweet(Kweet kweet){
        kd.delete(kweet);
    }
}
