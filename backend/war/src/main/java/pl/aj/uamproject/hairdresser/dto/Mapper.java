package pl.aj.uamproject.hairdresser.dto;

import pl.aj.uamproject.hairdresser.model.Appointment;
import pl.aj.uamproject.hairdresser.model.Client;
import pl.aj.uamproject.hairdresser.model.Employee;

import java.util.Date;

public class Mapper {
    public ClientDTO ClientToClientDTO(Client item){
        return new ClientDTO(item.getId(),item.getFirstName(),item.getLastName(),item.getEmail(),item.getPhoneNumber());
    }
    public Client ClientDTOToClient(ClientDTO item){
        return new Client(item.getId(), item.getFirstName(), item.getLastName(), item.getEmail(), item.getPhoneNumber());
    }
    public EmployeeDTO EmployeeToEmployeeDTO(Employee employee){
        return new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName());
    }
    public Employee EmployeeDTOToEmployee(EmployeeDTO employee){
        return new Employee(employee.getId(), employee.getFirstName(), employee.getLastName());
    }
    public AppointmentDTO AppointmentToAppointmentDTO(Appointment item){
        return new AppointmentDTO(item.getId(), item.getAppointmentDate().getTime(), EmployeeToEmployeeDTO(item.getEmployee()), ClientToClientDTO(item.getClient()));
    }
    public Appointment AppointmentCreateDTOToAppointment(AppointmentCreateDTO item, Client client, Employee employee){
        return new Appointment(item.getId(), client, employee, new Date(item.getAppointmentDate()));
    }
}


