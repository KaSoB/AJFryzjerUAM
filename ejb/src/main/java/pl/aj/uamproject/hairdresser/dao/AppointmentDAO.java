package pl.aj.uamproject.hairdresser.dao;

import pl.aj.uamproject.hairdresser.model.Appointment;
import pl.aj.uamproject.hairdresser.model.Client;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Startup
@Singleton
public class AppointmentDAO {
    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    public AppointmentDAO() {
    }

    @PostConstruct
    void init() {
    }

    public Optional<Appointment> getById(int id) {
        Appointment appointment = em.
                createQuery(
                        "SELECT c FROM Appointment c WHERE c.id=:id", Appointment.class)
                .setParameter("id", id)
                .setMaxResults(1).getSingleResult();
        return Optional.of(appointment);
    }

    public Optional<List<Appointment>> getAll() {
        List<Appointment> items = em.
                createQuery(
                        "SELECT c FROM Appointment c", Appointment.class)
                .getResultList();
        return Optional.of(items);
    }

    public Appointment add(Appointment appointment) {
        em.persist(appointment);
        return appointment;
    }

    public boolean remove(int id) {
        Optional<Appointment> appointment = getById(id);
        if (appointment.isPresent()) {
            em.remove(appointment.get());
            return true;
        } else {
            return false;
        }
    }

    public Appointment update(Appointment item) {
        em.merge(item);
        return item;
    }
}
