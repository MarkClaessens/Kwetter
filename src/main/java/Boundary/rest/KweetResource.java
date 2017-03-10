package Boundary.rest;

import domain.Kweet;
import service.KweetService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
    public List<Kweet> allkweets(){
        return ks.allkweets();
    }
}
