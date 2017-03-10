package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Slashy on 9-3-2017.
 */
public class UserTest {

    private User testuser1;
    private User testuser2;
    private User testuser3;
    private User testuser4;
    private User testuser5;
    private User testuser6;
    private User testuser7;
    private User testuser8;
    private User testuser9;
    private User testuser10;

    @Before
    public void setUp() throws Exception {
        testuser1 = new User("Tom", "mot", ROLE.NORMAL_USER);
        testuser2 = new User("Henk", "kneh", ROLE.NORMAL_USER);
        testuser3 = new User("Bas", "sab", ROLE.NORMAL_USER);
        testuser4 = new User("Klaas", "saalk", ROLE.NORMAL_USER);
        testuser5 = new User("Kees", "seek", ROLE.NORMAL_USER);
        testuser6 = new User("Jan", "naj", ROLE.ADMINISTRATOR_USER);
        testuser7 = new User("Stef", "fets", ROLE.ADMINISTRATOR_USER);
        testuser8 = new User("Jos", "soj", ROLE.ADMINISTRATOR_USER);
        testuser9 = new User("Mark", "kram", ROLE.ADMINISTRATOR_USER);
        testuser10 = new User("Karel", "lerak", ROLE.ADMINISTRATOR_USER);
    }

    @Test
    public void getUserName() throws Exception {
        Assert.assertEquals("name incorrect", "Tom", testuser1.getUserName());
        Assert.assertNotEquals("name correct", "Tom", testuser2.getUserName());
    }

    @Test
    public void setUserName() throws Exception {
        Assert.assertEquals("name incorrect", "Tom", testuser1.getUserName());
        testuser1.setUserName("Joep");
        Assert.assertNotEquals("name correct", "Tom", testuser1.getUserName());
        Assert.assertEquals("name incorrect", "Joep", testuser1.getUserName());
        Assert.assertNotEquals("name correct", "Tom", testuser2.getUserName());
        testuser2.setUserName("Tom");
        Assert.assertEquals("name incorrect", "Tom", testuser2.getUserName());
        Assert.assertNotEquals("name correct", "Henk", testuser2.getUserName());
    }

    @Test
    public void getPassWord() throws Exception {
        Assert.assertEquals("password incorrect", "sab", testuser3.getPassWord());
        Assert.assertNotEquals("password correct", "klaas", testuser4.getPassWord());
    }

    @Test
    public void setPassWord() throws Exception {
        Assert.assertEquals("password incorrect", "sab", testuser3.getPassWord());
        testuser3.setPassWord("sba");
        Assert.assertNotEquals("password correct", "sab", testuser3.getPassWord());
        Assert.assertEquals("password incorrect", "sba", testuser3.getPassWord());
        Assert.assertNotEquals("password correct", "klaas", testuser4.getPassWord());
        testuser4.setPassWord("slaak");
        Assert.assertEquals("password incorrect", "slaak", testuser4.getPassWord());
        Assert.assertNotEquals("password correct", "saalk", testuser4.getPassWord());
    }

    @Test
    public void getRole() throws Exception {
        Assert.assertEquals("role incorrect", ROLE.NORMAL_USER, testuser5.getRole());
        Assert.assertEquals("role incorrect", ROLE.ADMINISTRATOR_USER, testuser6.getRole());
        Assert.assertNotEquals("role correct", ROLE.ADMINISTRATOR_USER, testuser5.getRole());
        Assert.assertNotEquals("role correct", ROLE.NORMAL_USER, testuser6.getRole());
    }

    @Test
    public void setRole() throws Exception {
        Assert.assertEquals("Role incorrect",  ROLE.NORMAL_USER, testuser5.getRole());
        testuser5.setRole(ROLE.ADMINISTRATOR_USER);
        Assert.assertNotEquals("Role correct",  ROLE.NORMAL_USER, testuser5.getRole());
        Assert.assertEquals("Role incorrect",  ROLE.ADMINISTRATOR_USER, testuser5.getRole());
        Assert.assertNotEquals("Role correct",  ROLE.ADMINISTRATOR_USER, testuser6.getRole());
        testuser6.setRole(ROLE.NORMAL_USER);
        Assert.assertEquals("Role incorrect",  ROLE.NORMAL_USER, testuser6.getRole());
        Assert.assertNotEquals("Role correct",  ROLE.ADMINISTRATOR_USER, testuser6.getRole());
    }

    @Test
    public void getFollowers() throws Exception {

    }

    @Test
    public void addFollower() throws Exception {
        Assert.assertEquals("role incorrect", ROLE.NORMAL_USER, testuser5.getRole());
    }

    @Test
    public void removeFollower() throws Exception {

    }

    @Test
    public void getFollowing() throws Exception {

    }

    @Test
    public void addFollowing() throws Exception {

    }

    @Test
    public void removeFollowing() throws Exception {

    }

    @Test
    public void getKweets() throws Exception {

    }

    @Test
    public void addKweet() throws Exception {

    }

    @Test
    public void removeKweet() throws Exception {

    }

    @Test
    public void getBio() throws Exception {

    }

    @Test
    public void setBio() throws Exception {

    }

    @Test
    public void getLocation() throws Exception {

    }

    @Test
    public void setLocation() throws Exception {

    }

    @Test
    public void getWebsite() throws Exception {

    }

    @Test
    public void setWebsite() throws Exception {

    }

}