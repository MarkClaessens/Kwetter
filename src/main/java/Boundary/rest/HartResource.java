package Boundary.rest;

import domain.Hart;
import service.HartService;
import service.KweetService;
import service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

/**
 * Created by Mark on 7-3-2017.
 */
@Stateless
@Path("hart")
public class HartResource {

    @Inject
    HartService hs;

    @Inject
    UserService us;

    @Inject
    KweetService ks;

    @GET
    @Produces("application/json")
    public List<Hart> allharts(){
        return hs.allharts();
    }

    @PUT
    @Path("like/{id}")
    @Consumes("application/json")
    public boolean likeDislike(@PathParam("id") int kweetId, JsonObject in){
        return hs.likeDislike(ks.getKweet(kweetId), us.getUser(in.getString("userName")));
    }

    @GET
    @Path("/kweet/{id}")
    @Produces("application/json")
    public List<Hart> getKweetSpecific(@PathParam("id") int id){
        return hs.getKweetSpecific(ks.getKweet(id));
    }

    @GET
    @Path("/user/{userName}")
    @Produces("application/json")
    public List<Hart> getUserSpecific(@PathParam("userName") String userName){

        return hs.getUserSpecific(us.getUser(userName));
    }

    @POST
    @Path("/create/{id}")
    @Consumes("application/json")
    public void createHart(@PathParam("id") int id, JsonObject in){
        hs.createHart(ks.getKweet(id), us.getUser(in.getString("userName")));
    }
}
