package Boundary.rest;

import domain.Kweet;
import domain.User;
import service.KweetService;
import service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by Mark on 7-3-2017.
 */
@Stateless
@Path("kweet")
public class KweetResource {
    @Inject
    KweetService ks;

    @Inject
    UserService us;

    @GET
    @Produces("application/json")
    public List<Kweet> allkweets(){
        return ks.allkweets();
    }

    @POST
    @Path("/create")
    @Consumes("application/json")
    @Produces("application/json")
    public Kweet createKweet(JsonObject in) {
            User user = us.getUser(in.getString("userName"));
            Kweet kweet = ks.createKweet(in.getString("message"));
            user.addKweet(kweet);
            return kweet;
    }

    @GET
    @Path("/search/{search}")
    @Consumes("application/json")
    @Produces("application/json")
    public List<Kweet> searchKweet(@PathParam("search") String message) {
        return ks.searchKweet(message);
    }


}
