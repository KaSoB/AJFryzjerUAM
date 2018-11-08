package pl.aj.uamproject.hairdresser.controller;

import pl.aj.uamproject.hairdresser.service.ClientInformationService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/")
public class ClientsController {

    ClientInformationService clientInformationService = new ClientInformationService();

    @GET
    @Produces("application/json; charset=UTF-8")
    @Path("clients")
    public Response getClients() {
        // Return some cliched textual content
        return Response.status(200).entity(clientInformationService.getAllClients()).build();
    }
}
