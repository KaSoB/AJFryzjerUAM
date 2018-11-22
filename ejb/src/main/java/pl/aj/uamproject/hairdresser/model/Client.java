package pl.aj.uamproject.hairdresser.model;

import pl.aj.uamproject.hairdresser.infrastructure.IEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable, IEntity<Client> {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<Appointment> appointments = new ArrayList<>();

    public Client() {

    }

    public Client(int id) {
        this.id = id;
    }

    public Client(Integer id, String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return id != null ? id.equals(client.id) : client.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void update(Client client) {
        this.id = client.id;
        this.firstName = client.firstName;
        this.lastName = client.lastName;
        this.email = client.email;
        this.phoneNumber = client.phoneNumber;
        this.appointments = client.appointments;
    }
}