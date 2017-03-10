package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Slashy on 9-3-2017.
 */
public class HartTest {

    private User testuser1;
    private User testuser2;
    private User testuser3;
    private Kweet testkweet1;
    private Kweet testkweet2;
    private Kweet testkweet3;
    private Hart testhart1;
    private Hart testhart2;
    private Hart testhart3;


    @Before
    public void setUp() throws Exception {
        testuser1 = new User("Tom", "mot", ROLE.NORMAL_USER);
        testuser2 = new User("Henk", "kneh", ROLE.NORMAL_USER);
        testuser3 = new User("Bas", "sab", ROLE.NORMAL_USER);
        Date date = new Date();
        testkweet1 = new Kweet("hoi",null, date);
        testkweet2 = new Kweet("Ik ben Mark",null, date);
        testkweet3 = new Kweet("doei",null, date);
        testhart1 = new Hart(testkweet1, testuser1);
        testhart2 = new Hart(testkweet2, testuser2);
        testhart3 = new Hart(testkweet3, testuser3);

    }

    @Test
    public void getKweet() throws Exception {
        Assert.assertEquals("Kweet incorrect", testkweet1, testhart1.getKweet());
        Assert.assertNotEquals("kweet correct", testkweet2, testhart1.getKweet());
        Assert.assertEquals("kweet incorrect", testkweet2, testhart2.getKweet());
    }

        @Test
    public void getUser() throws Exception {
            Assert.assertEquals("user incorrect", testuser3, testhart3.getUser());
            Assert.assertNotEquals("user correct", testuser2, testhart3.getUser());
            Assert.assertEquals("user incorrect", testuser2, testhart2.getUser());
    }

}