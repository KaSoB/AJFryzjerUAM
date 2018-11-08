package pl.aj.uamproject.hairdresser;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

public class HelloWorldResources {

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("text/plain")
    @Path("/helloworld")
    public Response getClichedMessage() {
        // Return some cliched textual content
        return Response.status(200).entity("Hello World").build();
    }
}
