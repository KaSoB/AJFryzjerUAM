package pl.aj.uamproject.hairdresser.dao;

import pl.aj.uamproject.hairdresser.infrastructure.DAO;
import pl.aj.uamproject.hairdresser.model.Client;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.*;
import java.util.stream.Collectors;

@Startup
@Singleton
public class ClientDAO {
    private final Set<Client> database = new HashSet<>();

    public ClientDAO(){
    }
    @PostConstruct
    void init(){
        database.add(new Client(1, "Jan", "Kowalski","jankowal@vp.pl", "698488394"));
        database.add(new Client(2, "Robert", "Nowak","robert@onet.pl", "123456789"));
        database.add(new Client(3, "Sebastian", "Chmielewski","chmielewskipolska@vp.pl", "569845316"));
        database.add(new Client(4, "Piotr", "Gajewski", "GajPiotr@vp.pl","745896321"));
        database.add(new Client(5, "Wiktoria", "Nowak", "nowak.wikotria@vp.pl","986532147"));
    }

    public List<Client> getClientByPhoneNumber(String phoneNumber){
        return database.stream().filter(e -> e.getPhoneNumber().equals(phoneNumber)).sorted(Comparator.comparing(Client::getId)).collect(Collectors.toList());
    }

    public List<Client> getClientByEmail(String email){
        return database.stream().filter(e -> e.getPhoneNumber().equals(email)).sorted(Comparator.comparing(Client::getId)).collect(Collectors.toList());
    }

    public List<Client> getClientByLastName(String lastName) {
        return database.stream().filter(e -> e.getLastName().equals(lastName)).sorted(Comparator.comparing(Client::getId)).collect(Collectors.toList());
    }


    public Optional<Client> getById(int id){
        return database.stream().filter(e -> e.getId() == id).findFirst();
    }

    public List<Client> getAll(){
        return database.stream().sorted(Comparator.comparing(Client::getId)).collect(Collectors.toList());
    }

    public Client add(Client client){
        int id = database.size() + 1; // current size + 1
        client.setId(id);
        database.add(client);
        return client;
    }

    public boolean remove(int id){
        return database.removeIf(it -> it.getId().equals(id));
    }

    public Client update(Client item){
        Optional<Client> clientDB = database.stream().filter(it -> it.getId().equals(item.getId())).findFirst();
        clientDB.ifPresent(it -> it.update(item));
        return clientDB.get(); // TODO: without isPresent, can return null
    }
}
