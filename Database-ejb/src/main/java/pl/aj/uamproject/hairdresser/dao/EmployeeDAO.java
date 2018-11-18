package pl.aj.uamproject.hairdresser.dao;

import pl.aj.uamproject.hairdresser.infrastructure.DAO;
import pl.aj.uamproject.hairdresser.model.Employee;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class EmployeeDAO extends DAO<Employee> {

    protected void init() {
        database.add(new Employee(1, "Jan", "Kowalski"));
        database.add(new Employee(2, "Robert", "Nowak"));
        database.add(new Employee(3, "Sebastian", "Chmielewski"));
        database.add(new Employee(4, "Piotr", "Gajewski"));
    }
}
