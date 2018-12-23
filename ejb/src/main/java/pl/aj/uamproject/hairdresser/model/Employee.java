package pl.aj.uamproject.hairdresser.model;
import pl.aj.uamproject.hairdresser.infrastructure.IEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Employee implements Serializable, IEntity<Employee> {


    /*
    @Version
    private Long version;*/

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "employee")
    private List<Appointment> appointments;

    public Employee() {

    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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



    public String getLastName() {
        return lastName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return id != null ? id.equals(employee.id) : employee.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void update(Employee employee) {
        this.id = employee.id;
        this.firstName = employee.firstName;
        this.lastName = employee.lastName;
    }
}