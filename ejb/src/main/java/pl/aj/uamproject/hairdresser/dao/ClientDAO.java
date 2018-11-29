package pl.aj.uamproject.hairdresser.dao;

import pl.aj.uamproject.hairdresser.model.Appointment;
import pl.aj.uamproject.hairdresser.model.Client;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.util.stream.Collectors;

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
        em.persist(new Client( "Robert", "Nowak", "robert@onet.pl", "123456789"));
        em.persist(new Client( "Sebastian", "Chmielewski", "chmielewskipolska@vp.pl", "569845316"));
        em.persist(new Client( "Piotr", "Gajewski", "GajPiotr@vp.pl", "745896321"));
        em.persist(new Client( "Wiktoria", "Nowak", "nowak.wikotria@vp.pl", "986532147"));
    }

    public List<Client> getClientByPhoneNumber(String phoneNumber) {
        return database.stream().filter(e -> e.getPhoneNumber().equals(phoneNumber)).sorted(Comparator.comparing(Client::getId)).collect(Collectors.toList());
    }

    public List<Client> getClientByEmail(String email) {
        return database.stream().filter(e -> e.getPhoneNumber().equals(email)).sorted(Comparator.comparing(Client::getId)).collect(Collectors.toList());
    }

    public List<Client> getClientByLastName(String lastName) {
        return database.stream().filter(e -> e.getLastName().equals(lastName)).sorted(Comparator.comparing(Client::getId)).collect(Collectors.toList());
    }


    public Optional<Client> getById(int id) {
        Client client = em.
                createQuery(
                "SELECT c FROM Client c WHERE c.id=:id", Client.class)
                .setParameter("id", id)
                .setMaxResults(1).getSingleResult();
        return Optional.of(client);
    }

    public List<Client> getAll() {
        return database.stream().sorted(Comparator.comparing(Client::getId)).collect(Collectors.toList());
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
