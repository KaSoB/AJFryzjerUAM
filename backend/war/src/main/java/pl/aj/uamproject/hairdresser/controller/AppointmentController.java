package pl.aj.uamproject.hairdresser.controller;

import pl.aj.uamproject.hairdresser.dao.AppointmentDAO;
import pl.aj.uamproject.hairdresser.dao.ClientDAO;
import pl.aj.uamproject.hairdresser.dao.EmployeeDAO;
import pl.aj.uamproject.hairdresser.dto.*;
import pl.aj.uamproject.hairdresser.model.Appointment;
import pl.aj.uamproject.hairdresser.model.Client;
import pl.aj.uamproject.hairdresser.model.Employee;
import pl.aj.uamproject.hairdresser.service.email.EmailService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("appointment")
@Produces("application/json; charset=UTF-8")
@Consumes("application/json; charset=UTF-8")
@RequestScoped
public class AppointmentController {
    @EJB
    private AppointmentDAO appointmentDAO = new AppointmentDAO();
    @EJB
    private ClientDAO clientDAO = new ClientDAO();
    @EJB
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    private Mapper mapper = new Mapper();

    private EmailService emailService = new EmailService();

    @GET
    public Response getAll() {
        Optional<List<Appointment>> data = appointmentDAO.getAll();
        if (!data.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        List<Appointment> items = data.get();
        List<AppointmentDTO> dto = new ArrayList<>();
        items.forEach(it -> dto.add(mapper.AppointmentToAppointmentDTO(it)));
        return Response.status(Response.Status.OK).entity(dto).build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") int id) {
        Optional<Appointment> data = appointmentDAO.getById(id);
        if (!data.isPresent()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Appointment item = data.get();
        AppointmentDTO dto = mapper.AppointmentToAppointmentDTO(item);
        return Response.status(Response.Status.OK).entity(dto).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") int id) {
        appointmentDAO.remove(id);
        return Response.status(204).build();
    }

    @POST
    public Response add(AppointmentCreateDTO appointment) {
        Optional<Client> clientData = clientDAO.getById(appointment.getClientId());
        Optional<Employee> employeeData = employeeDAO.getById(appointment.getEmployeeId());
        if (!clientData.isPresent() || !employeeData.isPresent()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Appointment entity = mapper.AppointmentCreateDTOToAppointment(appointment,clientData.get(),employeeData.get());
        Appointment ret = appointmentDAO.add(entity);
        AppointmentDTO dto = mapper.AppointmentToAppointmentDTO(ret);

        // send email
        emailService.sendEmail(entity.getClient().getEmail(),entity.getAppointmentDate());
        // returns AppointmentDTO, not AppointmentCreateDTO
        return Response.status(Response.Status.CREATED).entity(dto).build();
    }

    @PUT
    public Response edit(AppointmentCreateDTO appointment) {
        Optional<Client> clientData = clientDAO.getById(appointment.getClientId());
        Optional<Employee> employeeData = employeeDAO.getById(appointment.getEmployeeId());
        if (!clientData.isPresent() || !employeeData.isPresent()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Appointment entity = mapper.AppointmentCreateDTOToAppointment(appointment,clientData.get(),employeeData.get());
        Appointment ret = appointmentDAO.update(entity);
        AppointmentDTO dto = mapper.AppointmentToAppointmentDTO(ret);

        // send email
        emailService.sendEmail(entity.getClient().getEmail(),entity.getAppointmentDate());
        // returns AppointmentDTO, not AppointmentCreateDTO
        return Response.status(Response.Status.OK).entity(dto).build();
    }
}

