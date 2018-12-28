package pl.aj.uamproject.hairdresser.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Appointment implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private Date appointmentDate;

    private Date appointmentCreate;

    private boolean isCancelled;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Employee employee;

    public Appointment() {
    }

    public Appointment(int id) {
        this.id = id;
    }

    public Appointment(Client client, Date appointmentDate, Date appointmentCreate, boolean isCancelled) {
        this.client = client;
        this.appointmentDate = appointmentDate;
        this.appointmentCreate = appointmentCreate;
        this.isCancelled = isCancelled;
    }

    public boolean getCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean value) {
        this.isCancelled = value;
    }

    public int getId() {
        return id;
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

    public Date getAppointmentCreate() {
        return appointmentCreate;
    }

    public void setAppointmentCreate(Date appointmentCreate) {
        this.appointmentCreate = appointmentCreate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void update(Appointment appointment) {
        this.id = appointment.id;
        this.client = appointment.client;
        this.appointmentDate = appointment.appointmentDate;
        this.appointmentCreate = appointment.appointmentCreate;
        this.isCancelled = appointment.isCancelled;
    }
}
