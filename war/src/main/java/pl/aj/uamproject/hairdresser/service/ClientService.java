package pl.aj.uamproject.hairdresser.service;

import pl.aj.uamproject.hairdresser.dao.ClientDAO;
import pl.aj.uamproject.hairdresser.model.Client;

import javax.ejb.EJB;
import java.util.*;

public class ClientService{
    @EJB
    private ClientDAO clientDAO = new ClientDAO();

    public List<Client> getAllClients() {
        return clientDAO.getAll();
    }

    public Client getClientById(int id){
        return  clientDAO.getById(id).get();
    }

    public List<Client> getClientByPhoneNumber(String phoneNumber){
        return clientDAO.getClientByPhoneNumber(phoneNumber);
    }

    public List<Client> getClientByEmail(String email){
        return  clientDAO.getClientByEmail(email);
    }

    public List<Client> getClientByLastName(String lastName){
        return clientDAO.getClientByLastName(lastName);
    }

    public Client add(Client client){
        return clientDAO.add(client);
    }

    public boolean remove(int id){
        return clientDAO.remove(id);
    }

    public Client edit(Client client){
        return clientDAO.update(client);
    }
}
