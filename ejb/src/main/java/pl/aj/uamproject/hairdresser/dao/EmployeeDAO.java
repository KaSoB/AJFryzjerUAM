package pl.aj.uamproject.hairdresser.dao;

import pl.aj.uamproject.hairdresser.model.Employee;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Startup
@Singleton
public class EmployeeDAO {

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    public EmployeeDAO() {
    }

    @PostConstruct
    void init() {
        em.persist(new Employee("Damian", "Walczak"));
        em.persist(new Employee("Franciszek ", "Romanowski"));
        em.persist(new Employee("Pawel", "Jankowski"));
        em.persist(new Employee("Krzysztof", "Nowicki"));
    }


    public Optional<Employee> getById(int id) {
        Employee employee = em.
                createQuery(
                        "SELECT e FROM Employee e WHERE e.id=:id", Employee.class)
                .setParameter("id", id)
                .setMaxResults(1).getSingleResult();
        return Optional.of(employee);
    }

    public Optional<List<Employee>> getAll() {
        List<Employee> employees = em.
                createQuery(
                        "SELECT e FROM Employee E", Employee.class)
                .getResultList();
        return Optional.of(employees);
    }

    public Employee add(Employee employee) {
        em.persist(employee);
        return employee;
    }

    public boolean remove(int id) {
        Optional<Employee> employeeData = getById(id);
        if (employeeData.isPresent()) {
            em.remove(employeeData.get());
            return true;
        } else {
            return false;
        }
    }

    public Employee update(Employee item) {
        em.merge(item);
        return item;
    }
}
