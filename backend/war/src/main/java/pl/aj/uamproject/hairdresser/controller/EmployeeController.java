package pl.aj.uamproject.hairdresser.controller;

import pl.aj.uamproject.hairdresser.dao.AppointmentDAO;
import pl.aj.uamproject.hairdresser.dao.EmployeeDAO;
import pl.aj.uamproject.hairdresser.dto.AppointmentDTO;
import pl.aj.uamproject.hairdresser.dto.EmployeeDTO;
import pl.aj.uamproject.hairdresser.dto.Mapper;
import pl.aj.uamproject.hairdresser.model.Appointment;
import pl.aj.uamproject.hairdresser.model.Employee;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("employee")
@Produces("application/json; charset=UTF-8")
@Consumes("application/json; charset=UTF-8")
@RequestScoped
public class EmployeeController {
    @EJB
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    @EJB
    private AppointmentDAO appointmentDAO = new AppointmentDAO();
    private Mapper mapper = new Mapper();
    @GET
    public Response getAll() {
        Optional<List<Employee>> data = employeeDAO.getAll();
        if (!data.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        List<Employee> items =  data.get();
        List<EmployeeDTO> dto = new ArrayList<>();
        items.forEach(it -> dto.add(mapper.EmployeeToEmployeeDTO(it)));
        return Response.status(Response.Status.OK).entity(dto).build();
    }

    @GET
    @Path("{id}/appointment")
    public Response getAppointmentsByClientId(@PathParam("id") int id) {
        Optional<List<Appointment>> data = appointmentDAO.getByEmployeeId(id);
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
        Optional<Employee> data = employeeDAO.getById(id);
        if (!data.isPresent()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Employee entity = data.get();
        EmployeeDTO dto = mapper.EmployeeToEmployeeDTO(entity);
        return Response.status(Response.Status.OK).entity(dto).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") int id) {
        employeeDAO.remove(id);
        return Response.status(204).build();
    }

    @POST
    public Response add(EmployeeDTO employee) {
        Employee entity = new Employee(employee.getFirstName(), employee.getLastName());
        Employee ret = employeeDAO.add(entity);
        EmployeeDTO dto = mapper.EmployeeToEmployeeDTO(ret);

        return Response.status(Response.Status.CREATED).entity(dto).build();
    }

    @PUT
    public Response edit(EmployeeDTO employee) {
        Employee entity = mapper.EmployeeDTOToEmployee(employee);
        Employee ret = employeeDAO.update(entity);
        EmployeeDTO dto = mapper.EmployeeToEmployeeDTO(ret);

        return Response.status(Response.Status.OK).entity(dto).build();
    }
}
