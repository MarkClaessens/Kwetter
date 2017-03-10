package Boundary.rest;

import domain.Hart;
import service.HartService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by Mark on 7-3-2017.
 */
@Stateless
@Path("hart")
public class HartResource {

    @Inject
    HartService hs;

    @GET
    public List<Hart> allharts(){
        return hs.allharts();
    }
}
