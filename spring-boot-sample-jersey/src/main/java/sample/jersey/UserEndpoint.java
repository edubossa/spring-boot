package sample.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

@Component
@Path("/user")
public class UserEndpoint {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get/")
	public Response getUser() {
		User user = new User("Eduardo", "Wallace");
		return Response.ok(user).status(Status.ACCEPTED).build();
	}

}