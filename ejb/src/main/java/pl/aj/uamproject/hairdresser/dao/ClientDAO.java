package pl.aj.uamproject.hairdresser.dao;

import pl.aj.uamproject.hairdresser.model.Appointment;
import pl.aj.uamproject.hairdresser.model.Client;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Startup
@Singleton
public class ClientDAO {
    private final Set<Client> database = new HashSet<>();

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    public ClientDAO() {
    }

    @PostConstruct
    void init() {
        em.persist(new Client("Jan", "Kowalski", "jankowal@vp.pl", "698488394"));
        em.persist(new Client("Robert", "Nowak", "robert@onet.pl", "123456789"));
        em.persist(new Client("Sebastian", "Chmielewski", "chmielewskipolska@vp.pl", "569845316"));
        em.persist(new Client("Piotr", "Gajewski", "GajPiotr@vp.pl", "745896321"));
        em.persist(new Client("Wiktoria", "Nowak", "nowak.wikotria@vp.pl", "986532147"));
    }

    public Optional<List<Client>> getClientByPhoneNumber(String phoneNumber) {
        List<Client> clients = em.
                createQuery(
                        "SELECT c FROM Client c WHERE c.phoneNumber=:phoneNumber", Client.class)
                .setParameter("phoneNumber", phoneNumber).getResultList();
        return Optional.of(clients);
    }

    public Optional<List<Client>> getClientByEmail(String email) {
        List<Client> clients = em.
                createQuery(
                        "SELECT c FROM Client c WHERE c.email=:email", Client.class)
                .setParameter("email", email).getResultList();
        return Optional.of(clients);
    }

    public Optional<List<Client>> getClientByLastName(String lastName) {
        List<Client> clients = em.
                createQuery(
                        "SELECT c FROM Client c WHERE c.lastname=:lastname", Client.class)
                .setParameter("lastName", lastName).getResultList();
        return Optional.of(clients);
    }


    public Optional<Client> getById(int id) {
        Client client = em.
                createQuery(
                        "SELECT c FROM Client c WHERE c.id=:id", Client.class)
                .setParameter("id", id)
                .setMaxResults(1).getSingleResult();
        return Optional.of(client);
    }

    public Optional<List<Client>> getAll() {
        List<Client> clients = em.
                createQuery(
                        "SELECT c FROM Client c", Client.class)
                .getResultList();
        return Optional.of(clients);
    }

    public Appointment addApointment(int clientId, Date appointmentDate) {
        Optional<Client> byId = getById(clientId);
        Client client = byId.get();
        Appointment appointment = new Appointment(client, appointmentDate);
        //client.getAppointments().add(appointment); // TODO: uncomment
        return appointment;
    }


    public Client add(Client client) {
        int id = database.size() + 1; // current size + 1
        client.setId(id);
        database.add(client);
        return client;
    }

    public boolean remove(int id) {
        return database.removeIf(it -> it.getId().equals(id));
    }

    public Client update(Client item) {
        Optional<Client> clientDB = database.stream().filter(it -> it.getId().equals(item.getId())).findFirst();
        clientDB.ifPresent(it -> it.update(item));
        return clientDB.get(); // TODO: without isPresent, can return null
    }
}
