package pl.aj.uamproject.hairdresser.model;

import pl.aj.uamproject.hairdresser.infrastructure.IEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Appointment implements IEntity<Appointment> {
    @Id
    @GeneratedValue
    private int id;
    private Date appointmentDate;
    private Client client;


    public Appointment() {
    }
    public Appointment(int id) {
        this.id = id;
    }
    public Appointment(Client client, Date appointmentDate) {
        this.client = client;
        this.appointmentDate = appointmentDate;
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
