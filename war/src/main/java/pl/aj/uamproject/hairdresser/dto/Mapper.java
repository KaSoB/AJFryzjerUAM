package pl.aj.uamproject.hairdresser.dto;


import pl.aj.uamproject.hairdresser.model.Client;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public List<ClientDTO> ClientToClientDTO(List<Client> items){
        List<ClientDTO> result = new ArrayList<>();
        items.forEach(it -> result.add(ClientToClientDTO(it)));
        return result;
    }
    public ClientDTO ClientToClientDTO(Client item){
        return new ClientDTO(item.getId(),item.getFirstName(),item.getLastName(),item.getEmail(),item.getPhoneNumber());
    }
    public List<Client> ClientDTOToClient(List<ClientDTO> items){
        List<Client> result = new ArrayList<>();
        items.forEach(it -> result.add(ClientDTOToClient(it)));
        return result;
    }
    public Client ClientDTOToClient(ClientDTO item){
        return new Client(item.getId(), item.getFirstName(), item.getLastName(), item.getEmail(), item.getPhoneNumber());
    }
}


