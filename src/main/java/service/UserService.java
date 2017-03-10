package service;

import dao.UserDAO;
import domain.Kweet;
import domain.User;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slashy on 4-3-2017.
 */
public class UserService {

    @Inject
    UserDAO ud;

    public List<User> allUsers(){
        return ud.allUsers();
    }

    public void addFollower(User thisUser, User otherUser){
        thisUser.addFollowing(otherUser);
        otherUser.addFollower(thisUser);
        ud.save(thisUser);
        ud.save(otherUser);
    }

    public List<String> getUserDetails(User thisUser){
        List<String> userDetails = new ArrayList<>();
        userDetails.add(thisUser.getBio());
        userDetails.add(thisUser.getLocation());
        userDetails.add(thisUser.getWebsite());
        return userDetails;
    }

    public boolean changeName(User thisUser, String newUserName){
        List<User> users = ud.allUsers();
        for(User user : users){
            if(user.getUserName().equals(newUserName)){
                return false;
            }
        }
        thisUser.setUserName(newUserName);
        ud.save(thisUser);
        return true;
    }

    public User login(String userName, String passWord){
        List<User> users = ud.allUsers();
        for(User user : users){
            if(user.getUserName().equals(userName) && user.getPassWord().equals(passWord)){
                return user;
            }
        }
        return null;
    }

    public List<Kweet> getFollowingTweets(User thisUser){
        List<User> users = ud.getSpecificFollowing(thisUser);
        List<Kweet> kweets = new ArrayList<>();
        kweets.addAll(thisUser.getKweets());
        for(User user : users){
            kweets.addAll(user.getKweets());
        }
        return kweets;
    }



}
