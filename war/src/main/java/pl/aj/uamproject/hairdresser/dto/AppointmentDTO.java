package pl.aj.uamproject.hairdresser.dto;

import java.util.Date;

public class AppointmentDTO {
    private Integer id;
    private Long appointmentDate;
    private EmployeeDTO employee;
    private ClientDTO client;

    public AppointmentDTO(){

    }

    public AppointmentDTO(Integer id, Long appointmentDate, EmployeeDTO employee, ClientDTO client) {
         this.id = id;
         this.appointmentDate = appointmentDate;
         this.employee = employee;
         this.client = client;
    }

    public Integer getId() {
        return id;
    }
    public Long getAppointmentDate() {
        return appointmentDate;
    }
    public EmployeeDTO getEmployee() {
        return employee;
    }
    public ClientDTO getClient() {
        return client;
    }
}