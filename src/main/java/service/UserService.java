package service;

import dao.UserDAO;
import domain.Group;
import domain.Kweet;
import domain.User;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    public String getUserDetails(User thisUser){
        String s = "BIO: " + thisUser.getBio() + " Website: " + thisUser.getWebsite() + " Location: " + thisUser.getLocation();
        return s;
    }

    public User changeName(String thisUserName, String newUserName){
        User thisUser = getUser(thisUserName);
        List<User> users = ud.allUsers();
        for(User user : users){
            if(user.getUserName().equals(newUserName)){
                return null;
            }
        }
        thisUser.setUserName(newUserName);
        ud.save(thisUser);
        return thisUser;
    }

    public User login(String userName, String passWord){
        List<User> users = ud.allUsers();
        for(User user : users){
            try {
                if(user.getUserName().equals(userName) && user.getPassWord().equals(toSha256(passWord))){
                    return user;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
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

    public void addKweet(User user, Kweet kweet){
        user.addKweet(kweet);
        ud.save(user);
    }

    public User createUser(String userName, String passWord){
        List<User> users = ud.allUsers();
        for(User user : users){
            if(user.getUserName().equals(userName)){
                return null;
            }
        }
        User user = null;
        try {
            user = new User(userName, toSha256(passWord), new Group());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        ud.save(user);
        return user;
    }

    private static String toSha256(String data) throws NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes());
            return bytesToHex(md.digest());
        } catch(Exception ex) {
            return null;
        }

    }
    private static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }


}
