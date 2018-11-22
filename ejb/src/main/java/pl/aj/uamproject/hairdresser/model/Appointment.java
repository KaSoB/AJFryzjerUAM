package pl.aj.uamproject.hairdresser.model;

import pl.aj.uamproject.hairdresser.infrastructure.IEntity;

import java.util.Date;

public class Appointment implements IEntity<Appointment> {
    private static int appointmentId = 1;


    private int id;
    private Date appointmentDate;
    private Client client;

    public Appointment(Client client, Date appointmentDate) {
        this.client = client;
        this.appointmentDate = appointmentDate;
        this.id = appointmentId++;
    }


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public void update(Appointment appointment) {
        this.id = appointment.id;
        this.client = appointment.client;
        this.appointmentDate = appointment.appointmentDate;
    }
}
