package pl.aj.uamproject.hairdresser.service;

import pl.aj.uamproject.hairdresser.dto.SimpleClientInfoDTO;
import pl.aj.uamproject.hairdresser.model.Client;

import java.util.*;
import java.util.stream.Collectors;

public class ClientInformationService {
    private final Set<SimpleClientInfoDTO> database = new HashSet<>();

    public ClientInformationService(){
        mockDatabase();
    }

    private void mockDatabase(){
        database.add(new SimpleClientInfoDTO(1, "Jan", "Kowalski", "698488394"));
        database.add(new SimpleClientInfoDTO(2, "Robert", "Nowak", "123456789"));
        database.add(new SimpleClientInfoDTO(3, "Sebastian", "Chmielewski", "569845316"));
        database.add(new SimpleClientInfoDTO(4, "Piotr", "Gajewski", "745896321"));
        database.add(new SimpleClientInfoDTO(5, "Wiktoria", "Nowak", "986532147"));
    }

    public List<SimpleClientInfoDTO> getAllClients() {
        return database.stream().sorted(Comparator.comparing(SimpleClientInfoDTO::getId)).collect(Collectors.toList());
    }

    public SimpleClientInfoDTO getClientById(long id){
        return database.stream().filter(client -> client.getId() == id).findFirst().get();
    }

    public SimpleClientInfoDTO getClientByPhoneNumber(String phoneNumber){
        return database.stream().filter(client -> client.getPhoneNumber().equals(phoneNumber)).findFirst().get();
    }

    public SimpleClientInfoDTO getClientByLastName(String lastName){
        return database.stream().filter(client -> client.getLastName().equals(lastName)).findFirst().get();
    }
}
