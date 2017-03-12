package service;

import dao.UserDAO;
import domain.Kweet;
import domain.ROLE;
import domain.User;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Slashy on 4-3-2017.
 */
@Model
public class UserService {

    @Inject
    UserDAO ud;

    public List<User> allUsers(){
        return ud.allUsers();
    }

    public void addFollower(String thisUserName, String otherUserName){
        User thisUser = getUser(thisUserName);
        User otherUser = getUser(otherUserName);
        thisUser.addFollowing(otherUser);
        otherUser.addFollower(thisUser);
        ud.save(thisUser);
        ud.save(otherUser);
    }

    public User getUser(String userName){return ud.getUser(userName);}

    public List<String> getUserDetails(User thisUser){
        List<String> userDetails = new ArrayList<>();
        userDetails.add(thisUser.getBio());
        userDetails.add(thisUser.getLocation());
        userDetails.add(thisUser.getWebsite());
        return userDetails;
    }

    public boolean changeName(String thisUserName, String newUserName){
        User thisUser = getUser(thisUserName);
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

    public User createUser(String userName, String passWord){
        List<User> users = ud.allUsers();
        for(User user : users){
            if(user.getUserName().equals(userName)){
                return null;
            }
        }
        User user = new User(userName, passWord, ROLE.NORMAL_USER);
        ud.save(user);
        return user;
    }


}
