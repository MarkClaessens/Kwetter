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
        testuser1 = new User("Tom", "mot", new Group());
        testuser2 = new User("Henk", "kneh", new Group());
        testuser3 = new User("Bas", "sab", new Group());
        testuser4 = new User("Klaas", "saalk", new Group());
        testuser5 = new User("Kees", "seek", new Group());
        testuser6 = new User("Jan", "naj", new Group());
        testuser7 = new User("Stef", "fets", new Group());
        testuser8 = new User("Jos", "soj", new Group());
        testuser9 = new User("Mark", "kram", new Group());
        testuser10 = new User("Karel", "lerak", new Group());
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
    public void getFollowers() throws Exception {
        Assert.assertEquals("password incorrect", "sab", testuser3.getPassWord());
        testuser3.setPassWord("sba");
        Assert.assertEquals("password incorrect", "sba", testuser3.getPassWord());
        Assert.assertNotEquals("password correct", "sab", testuser3.getPassWord());
        Assert.assertNotEquals("password correct", "klaas", testuser4.getPassWord());
        testuser4.setPassWord("slaak");
        Assert.assertEquals("password incorrect", "slaak", testuser4.getPassWord());
        Assert.assertNotEquals("password correct", "saalk", testuser4.getPassWord());
    }

    @Test
    public void getFollowing() throws Exception {
        Assert.assertEquals("password incorrect", "sab", testuser3.getPassWord());
        testuser3.setPassWord("sba");
        Assert.assertNotEquals("password correct", "sab", testuser3.getPassWord());
        Assert.assertNotEquals("password correct", "klaas", testuser4.getPassWord());
        testuser4.setPassWord("slaak");
        Assert.assertEquals("password incorrect", "slaak", testuser4.getPassWord());
        Assert.assertNotEquals("password correct", "saalk", testuser4.getPassWord());
    }

    @Test
    public void getKweets() throws Exception {
        Assert.assertEquals("password incorrect", "sab", testuser3.getPassWord());
        testuser3.setPassWord("sba");
        Assert.assertEquals("password incorrect", "sba", testuser3.getPassWord());
        Assert.assertNotEquals("password correct", "klaas", testuser4.getPassWord());
        testuser4.setPassWord("slaak");
        Assert.assertEquals("password incorrect", "slaak", testuser4.getPassWord());
        Assert.assertNotEquals("password correct", "saalk", testuser4.getPassWord());
    }

    @Test
    public void getBio() throws Exception {
        testuser3.setBio("hoi");
        Assert.assertEquals("password incorrect", "hoi", testuser3.getBio());
        Assert.assertNotEquals("password correct", "hoi", testuser4.getBio());
    }

    @Test
    public void setBio() throws Exception {
        Assert.assertEquals("bio incorrect", "", testuser3.getBio());
        testuser3.setBio("sba");
        Assert.assertEquals("bio incorrect", "sba", testuser3.getBio());
        Assert.assertNotEquals("bio correct", "sab", testuser3.getBio());
        Assert.assertEquals("bio correct", "", testuser4.getBio());
        testuser4.setBio("slaak");
        Assert.assertEquals("bio incorrect", "slaak", testuser4.getBio());
        Assert.assertNotEquals("bio correct", "saalk", testuser4.getBio());
    }

    @Test
    public void getLocation() throws Exception {
        testuser3.setLocation("hoi");
        Assert.assertEquals("password incorrect", "hoi", testuser3.getLocation());
        Assert.assertNotEquals("password correct", "hoi", testuser4.getLocation());
    }

    @Test
    public void setLocation() throws Exception {
        Assert.assertEquals("location incorrect", "", testuser3.getLocation());
        testuser3.setLocation("sba");
        Assert.assertEquals("location incorrect", "sba", testuser3.getLocation());
        Assert.assertNotEquals("location correct", "sab", testuser3.getLocation());
        Assert.assertEquals("location correct", "", testuser4.getLocation());
        testuser4.setLocation("slaak");
        Assert.assertEquals("location incorrect", "slaak", testuser4.getLocation());
        Assert.assertNotEquals("location correct", "saalk", testuser4.getLocation());
    }

    @Test
    public void getWebsite() throws Exception {
        testuser3.setWebsite("hoi");
        Assert.assertEquals("password incorrect", "hoi", testuser3.getWebsite());
        Assert.assertNotEquals("password correct", "hoi", testuser4.getWebsite());
    }

    @Test
    public void setWebsite() throws Exception {
        Assert.assertEquals("website incorrect", "", testuser3.getWebsite());
        testuser3.setWebsite("sba");
        Assert.assertEquals("website incorrect", "sba", testuser3.getWebsite());
        Assert.assertNotEquals("website correct", "sab", testuser3.getWebsite());
        Assert.assertEquals("website correct", "", testuser4.getWebsite());
        testuser4.setWebsite("slaak");
        Assert.assertEquals("website incorrect", "slaak", testuser4.getWebsite());
        Assert.assertNotEquals("website correct", "saalk", testuser4.getWebsite());
    }

}