package pl.aj.uamproject.hairdresser.service;

import pl.aj.uamproject.hairdresser.dto.SimpleClientInfoDTO;
import pl.aj.uamproject.hairdresser.model.Client;

import java.util.ArrayList;

public class ClientInformationService {
    public ArrayList<SimpleClientInfoDTO> getAllClients() {
        ArrayList<SimpleClientInfoDTO> clients = new ArrayList<>();
        clients.add(new SimpleClientInfoDTO(1, "Jan", "Kowalski", "698488394"));
        return clients;
    }
}
