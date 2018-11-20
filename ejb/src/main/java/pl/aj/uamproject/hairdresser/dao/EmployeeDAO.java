package pl.aj.uamproject.hairdresser.dao;

import pl.aj.uamproject.hairdresser.infrastructure.DAO;
import pl.aj.uamproject.hairdresser.model.Client;
import pl.aj.uamproject.hairdresser.model.Employee;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.*;
import java.util.stream.Collectors;

@Startup
@Singleton
public class EmployeeDAO {
    private final Set<Employee> database = new HashSet<>();

    public EmployeeDAO(){
    }
    @PostConstruct
    void init(){
        database.add(new Employee(1, "Jan", "Kowalski"));
        database.add(new Employee(2, "Robert", "Nowak"));
        database.add(new Employee(3, "Sebastian", "Chmielewski"));
        database.add(new Employee(4, "Piotr", "Gajewski"));
    }



    public Optional<Employee> getById(int id){
        return database.stream().filter(e -> e.getId() == id).findFirst();
    }

    public List<Employee> getAll(){
        return database.stream().sorted(Comparator.comparing(Employee::getId)).collect(Collectors.toList());
    }

    public Employee add(Employee employee){
        int id = database.size() + 1; // current size + 1
        employee.setId(id);
        database.add(employee);
        return employee;
    }

    public boolean remove(int id){
        database.clear();
        return true;
    }

    public Employee update(Employee item){
        Optional<Employee> employeeDB = database.stream().filter(it -> it.getId().equals(item.getId())).findFirst();
        employeeDB.ifPresent(it -> it.update(item));
        return employeeDB.get(); // TODO: without isPresent, can return null
    }
}
