package pl.aj.uamproject.hairdresser.controller;

import pl.aj.uamproject.hairdresser.dao.AppointmentDAO;
import pl.aj.uamproject.hairdresser.dao.ClientDAO;
import pl.aj.uamproject.hairdresser.dto.AppointmentDTO;
import pl.aj.uamproject.hairdresser.dto.ClientDTO;
import pl.aj.uamproject.hairdresser.dto.Mapper;
import pl.aj.uamproject.hairdresser.model.Appointment;
import pl.aj.uamproject.hairdresser.model.Client;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Path("client")
@Produces("application/json; charset=UTF-8")
@RequestScoped
public class ClientController {
    @EJB
    private ClientDAO clientDAO = new ClientDAO();
    @EJB
    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    private Mapper mapper = new Mapper();

    @GET
    public Response getAll() {
        Optional<List<Client>> clientsData = clientDAO.getAll();
        if (clientsData.isPresent()) {
            List<Client> items = clientsData.get();
            List<ClientDTO> dto = new ArrayList<>();
            items.forEach(it -> dto.add(mapper.ClientToClientDTO(it)));
            return Response.status(Response.Status.OK).entity(dto).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("{id}/appointment")
    public Response getAppointmentsByClientId(@PathParam("id") int id) {
        Optional<List<Appointment>> clientsData = appointmentDAO.getByClientId(id);
        if (!clientsData.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        List<Appointment> items = clientsData.get();
        List<AppointmentDTO> dto = new ArrayList<>();
        items.forEach(it -> dto.add(mapper.AppointmentToAppointmentDTO(it)));
        return Response.status(Response.Status.OK).entity(dto).build();
    }


    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") int id) {
        Optional<Client> clientData = clientDAO.getById(id);
        if (!clientData.isPresent()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Client client = clientData.get();
        ClientDTO clientDTO = mapper.ClientToClientDTO(client);
        return Response.status(Response.Status.OK).entity(clientDTO).build();
    }

    @GET
    @Path("phoneNumber/{phoneNumber}")
    public Response getByPhoneNumber(String phoneNumber) {
        Optional<List<Client>> itemData = clientDAO.getClientByPhoneNumber(phoneNumber);
        if (itemData.isPresent()) {
            List<Client> items = itemData.get();
            List<ClientDTO> dto = new ArrayList<>();
            items.forEach(it -> dto.add(mapper.ClientToClientDTO(it)));
            return Response.status(Response.Status.OK).entity(dto).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("lastName/{lastName}")
    public Response getByLastName(String lastName) {
        Optional<List<Client>> itemData = clientDAO.getClientByLastName(lastName);
        if (itemData.isPresent()) {
            List<Client> items = itemData.get();
            List<ClientDTO> dto = new ArrayList<>();
            items.forEach(it -> dto.add(mapper.ClientToClientDTO(it)));
            return Response.status(Response.Status.OK).entity(dto).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("email/{email}")
    public Response getByEmail(String email) {
        Optional<List<Client>> itemData = clientDAO.getClientByEmail(email);
        if (itemData.isPresent()) {
            List<Client> items = itemData.get();
            List<ClientDTO> dto = new ArrayList<>();
            items.forEach(it -> dto.add(mapper.ClientToClientDTO(it)));
            return Response.status(Response.Status.OK).entity(dto).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes("application/json; charset=UTF-8")
    @Produces("application/json; charset=UTF-8")
    public Response addClient(ClientDTO client) {
        Client entity = mapper.ClientDTOToClient(client);
        Client ret = clientDAO.add(entity);
        ClientDTO clientDTO = mapper.ClientToClientDTO(ret);

        return Response.status(Response.Status.CREATED).entity(clientDTO).build();
    }



    @GET
    @Path("{id}/appointments")
    public Response getByLastName(int clientId) {
        Optional<Client> clientData = clientDAO.getById(clientId);
        if (!clientData.isPresent()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Client client = clientData.get();
        List<Appointment> appointments = client.getAppointments();
        List<AppointmentDTO> appointmentDTOs = new ArrayList<>();
//        for (Appointment appointment : appointments) {//TODO:uncomment
//            appointmentDTOs.add(new AppointmentDTO(appointment));
//        }
        return Response.status(200).entity(appointmentDTOs).build(); // TODO: ucnommnect
        //return Response.status(Response.Status.OK).entity(1).build();
    }


    @DELETE
    @Path("{id}")
    @Produces("application/json; charset=UTF-8")
    public Response remove(@PathParam("id") int id) {
        clientDAO.remove(id);
        return Response.status(204).build();
    }

    @PUT
    @Produces("application/json; charset=UTF-8")
    public Response edit(ClientDTO client) {
        Client entity = mapper.ClientDTOToClient(client);
        Client ret = clientDAO.update(entity);
        ClientDTO clientDTO = mapper.ClientToClientDTO(ret);

        return Response.status(Response.Status.OK).entity(clientDTO).build();
    }
}
