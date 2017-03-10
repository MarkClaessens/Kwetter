package Boundary.rest;

import domain.User;
import service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
    public List<User> allUsers(){
        return us.allUsers();
    }

}
