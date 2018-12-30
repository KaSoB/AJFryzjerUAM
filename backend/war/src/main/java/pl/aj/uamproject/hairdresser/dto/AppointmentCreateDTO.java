package pl.aj.uamproject.hairdresser.dto;

import java.util.Date;

public class AppointmentCreateDTO {
    private int id;
    private Long appointmentDate;
    private int employeeId;
    private int clientId;

    public AppointmentCreateDTO(){

    }
    public AppointmentCreateDTO(int id, Long appointmentDate, int employeeId, int clientId) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.employeeId = employeeId;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Long getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(Long va) {
        this.appointmentDate = va;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int va) {
        this.employeeId = va;
    }
    public int getClientId() {
        return clientId;
    }
    public void setClientId(int va) {
        this.clientId = va;
    }
}
