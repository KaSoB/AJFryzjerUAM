package pl.aj.uamproject.hairdresser.controller;

import pl.aj.uamproject.hairdresser.dao.ClientDAO;
import pl.aj.uamproject.hairdresser.dto.ClientDTO;
import pl.aj.uamproject.hairdresser.dto.Mapper;
import pl.aj.uamproject.hairdresser.model.Client;
import pl.aj.uamproject.hairdresser.service.ClientService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("client")
@Produces("application/json; charset=UTF-8")
public class ClientController {
    @EJB
    private ClientDAO clientDAO = new ClientDAO();
    private Mapper mapper = new Mapper();
    @GET
    public Response getAll() {
        List<Client> items = clientDAO.getAll();
        List<ClientDTO> dto = mapper.ClientToClientDTO(items);

        return Response.status(200).entity(dto).build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") int id) {
        Client item = clientDAO.getById(id).get();
        ClientDTO dto = mapper.ClientToClientDTO(item);

        return Response.status(200).entity(dto).build();
    }

    @GET
    @Path("phoneNumber/{phoneNumber}")
    public Response getByPhoneNumber(String phoneNumber) {
        List<Client> item = clientDAO.getClientByPhoneNumber(phoneNumber);
        List<ClientDTO> dto = mapper.ClientToClientDTO(item);

        return Response.status(200).entity(dto).build();
    }

    @GET
    @Path("lastName/{lastName}")
    public Response getByLastName(String lastName) {
        List<Client> item = clientDAO.getClientByLastName(lastName);
        List<ClientDTO> dto = mapper.ClientToClientDTO(item);

        return Response.status(200).entity(dto).build();
    }

    @GET
    @Path("email/{email}")
    public Response getByEmail(String email) {
        List<Client> item = clientDAO.getClientByEmail(email);
        List<ClientDTO> dto = mapper.ClientToClientDTO(item);

        return Response.status(200).entity(dto).build();
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response add(ClientDTO client) {
        Client entity = mapper.ClientDTOToClient(client);
        Client ret = clientDAO.add(entity);

        return Response.status(201).entity(ret).build();
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json; charset=UTF-8")
    public Response remove(@PathParam("id") int id) {
        clientDAO.remove(id); // TODO: use return value
        return Response.status(204).build();
    }

    @PUT
    @Produces("application/json; charset=UTF-8")
    public Response edit(ClientDTO client) {
        Client entity = mapper.ClientDTOToClient(client);
        Client ret =  clientDAO.update(entity);

        return Response.status(200).entity(ret).build();
    }
}