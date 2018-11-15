package pl.aj.uamproject.hairdresser.controller;

import pl.aj.uamproject.hairdresser.dto.SimpleClientInfoDTO;
import pl.aj.uamproject.hairdresser.service.ClientInformationService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("client")
@Produces("application/json; charset=UTF-8")
public class ClientController {

    private ClientInformationService clientInformationService = new ClientInformationService();

    @GET
    public Response getAll() {
        List<SimpleClientInfoDTO> items = clientInformationService.getAllClients();
        return Response.status(200).entity(items).build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") long id) {
        SimpleClientInfoDTO item = clientInformationService.getClientById(id);
        return Response.status(200).entity(item).build();
    }

    @GET
    @Path("phoneNumber")
    public Response getByPhoneNumber(@Context UriInfo info) {
        String phoneNumber = info.getQueryParameters().getFirst("phoneNumber");
        SimpleClientInfoDTO item = clientInformationService.getClientByPhoneNumber(phoneNumber);
        return Response.status(200).entity(item).build();
    }

    @GET
    @Path("lastName")
    public Response getByLastName(@Context UriInfo info) {
        String lastName = info.getQueryParameters().getFirst("lastName");
        SimpleClientInfoDTO item = clientInformationService.getClientByLastName(lastName);
        return Response.status(200).entity(item).build();
    }
}
