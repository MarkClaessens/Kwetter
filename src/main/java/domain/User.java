package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Mark on 7-3-2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "user.all", query = "SELECT u FROM User u"),
        @NamedQuery(name = "user.byUserName", query = "SELECT u FROM User u WHERE u.userName = :userName"),
        @NamedQuery(name = "user.findfollowing", query = "SELECT u FROM User u WHERE u.following = :user")
})

public class User {

    @Id
    private String userName;
    private String passWord;
    private ROLE role;
    private String bio;
    private String location;
    private String website;
    @OneToMany
    private List<User> followers;
    @OneToMany
    private List<User> following;
    @OneToMany
    private List<Kweet> kweets;

    public User(){}
    public User(String userName, String passWord, ROLE role){
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
        this.bio = "";
        this.location = "";
        this.website = "";
        followers = new ArrayList<>();
        following = new ArrayList<>();
        kweets = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void addFollower(User user){
        followers.add(user);
    }

    public void removeFollower(User user){
        if(followers.contains(user)){
            followers.remove(user);
        }
    }

    public List<User> getFollowing() {
        return following;
    }

    public void addFollowing(User user){
        following.add(user);
    }

    public void removeFollowing(User user){
        if(following.contains(user)){
            following.remove(user);
        }
    }

    public List<Kweet> getKweets() {
        return kweets;
    }

    public void addKweet(Kweet kweet){
        kweets.add(kweet);
    }

    public void removeKweet(Kweet kweet){
        if(kweets.contains(kweet)){
            kweets.remove(kweet);
        }
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    @Override
    public String toString(){
        return "username: " + userName + ", role: " + role;
    }

}
