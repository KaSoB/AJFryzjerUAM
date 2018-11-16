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
public class ClientDAO extends DAO<Client> {

    protected void init(){
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

}
