package pl.aj.uamproject.hairdresser.service;

import pl.aj.uamproject.hairdresser.dao.ClientDAO;
import pl.aj.uamproject.hairdresser.dto.SimpleClientInfoDTO;
import pl.aj.uamproject.hairdresser.model.Client;

import java.util.*;
import java.util.stream.Collectors;

public class ClientInformationService {
    private ClientDAO clientDAO = new ClientDAO();

    public List<Client> getAllClients() {
       return clientDAO.getAll();
    }

    public Client getClientById(int id){
       return clientDAO.getById(id).get();
    }

    public List<Client> getClientByPhoneNumber(String phoneNumber){
      return clientDAO.getClientByPhoneNumber(phoneNumber);
    }

    public List<Client> getClientByEmail(String email){
        return clientDAO.getClientByEmail(email);
    }

    public List<Client> getClientByLastName(String lastName){
        return clientDAO.getClientByLastName(lastName);
    }
}
