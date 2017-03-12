package Boundary.rest;

import domain.Kweet;
import service.KweetService;

import javax.ejb.Stateless;
import javax.inject.Inject;
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

    @GET
    @Produces("application/json")
    public List<Kweet> allkweets(){
        return ks.allkweets();
    }

    @POST
    @Path("/create")
    @Consumes("application/json")
    @Produces("application/json")
    public Kweet createKweet(String message){
            return ks.createKweet(message);
    }

    @GET
    @Path("/search/{search}")
    @Consumes("application/json")
    @Produces("application/json")
    public List<Kweet> searchKweet(@PathParam("search") String message) {
        return ks.searchKweet(message);
    }

    @DELETE
    @Path("/delete/{id}")
    public void deleteKweet(@PathParam("id") int id) {
        ks.deleteKweet(ks.getKweet(id));
    }
}
