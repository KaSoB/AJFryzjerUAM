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


    @ManyToOne
    private Client client;

    @ManyToOne
    private Employee employee;

    public Appointment() {

    }

    public Appointment(int id, Client client, Employee employee, Date appointmentDate) {
        this.id = id;
        this.employee = employee;
        this.client = client;
        this.appointmentDate = appointmentDate;
    }

    public Appointment(Client client, Employee employee, Date appointmentDate) {
        this.employee = employee;
        this.client = client;
        this.appointmentDate = appointmentDate;
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

}
