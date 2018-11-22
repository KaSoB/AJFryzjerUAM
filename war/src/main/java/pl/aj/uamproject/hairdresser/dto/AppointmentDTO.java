package pl.aj.uamproject.hairdresser.dto;

import pl.aj.uamproject.hairdresser.model.Appointment;

import java.util.Date;

public class AppointmentDTO {
    private final Integer id;
    private final Date appointmentDate;

    public AppointmentDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.appointmentDate = appointment.getAppointmentDate();
    }

    public Integer getId() {
        return id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }
}
