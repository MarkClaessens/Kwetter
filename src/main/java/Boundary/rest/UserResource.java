package Boundary.rest;

import domain.Kweet;
import domain.User;
import service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by Slashy on 4-3-2017.
 */
@Stateless
@Path("user")
public class UserResource {

    @Inject
    UserService us;

    @GET
    @Produces("application/json")
    public List<User> allUsers(){
        return us.allUsers();
    }

    @PUT
    @Path("/addfollower/{otherUserName}")
    @Consumes("application/json")
    public void addFollower(@PathParam("otherUserName")String otherUser, String thisUser){
        us.addFollower(thisUser, otherUser);
    }

    @GET
    @Path("/details/{userName}")
    @Produces("application/json")
    public List<String> getUserDetails(@PathParam("userName") String userName){
        User user = us.getUser(userName);
        return us.getUserDetails(user);
    }

    @PUT
    @Path("/changename/{userName}")
    @Consumes("application/json")
    public boolean changeName(@PathParam("userName") String userName, String oldName){
        return us.changeName(oldName, userName);
    }

    @POST
    @Path("/login/{username}")
    @Consumes("application/json")
    @Produces("application/json")
    public User login(@PathParam("username")String userName, String passWord){
        return us.login(userName, passWord);
    }

    @GET
    @Path("/following/{userName}")
    public List<Kweet> getFollowingTweets(@PathParam("userName") String userName){
        User user = us.getUser(userName);
        return us.getFollowingTweets(user);
    }

    @POST
    @Path("/create/{userName}")
    @Consumes("application/json")
    @Produces("application/json")
    public User createUser(@PathParam("userName") String userName, String passWord){
         return us.createUser(userName, passWord);
    }
}
