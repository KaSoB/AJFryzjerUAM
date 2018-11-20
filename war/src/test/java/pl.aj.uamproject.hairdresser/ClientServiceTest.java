package pl.aj.uamproject.hairdresser;


import org.junit.jupiter.api.Test;
import pl.aj.uamproject.hairdresser.model.Client;
import pl.aj.uamproject.hairdresser.service.ClientService;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientServiceTest {

    private ClientService clientService = new ClientService();

    @Test
    void getAllClients() {
        List<Client> allClients = clientService.getAllClients();
        assertEquals(0, allClients.size());
    }
//
//    @Test
//    public void getById() {
//        Client simpleClientInfoDTO = clientService.getClientById(1);
//        assertEquals("Jan", simpleClientInfoDTO.getFirstName());
//        assertEquals("Kowalski", simpleClientInfoDTO.getLastName());
//        assertEquals(1, simpleClientInfoDTO.getId());
//        assertEquals("698488394", simpleClientInfoDTO.getPhoneNumber());
//    }
//
//    @Test
//    public void getByLastName() {
//        Client simpleClientInfoDTO = clientService.getClientByLastName("Gajewski");
//        assertEquals("Piotr", simpleClientInfoDTO.getFirstName());
//        assertEquals("Gajewski", simpleClientInfoDTO.getLastName());
//        assertEquals(4, simpleClientInfoDTO.getId());
//        assertEquals("745896321", simpleClientInfoDTO.getPhoneNumber());
//    }
//
//    @Test
//    public void getByPhoneNumber() {
//        Client simpleClientInfoDTO = clientService.getClientByPhoneNumber("745896321");
//        assertEquals("Piotr", simpleClientInfoDTO.getFirstName());
//        assertEquals("Gajewski", simpleClientInfoDTO.getLastName());
//        assertEquals(4, simpleClientInfoDTO.getId());
//        assertEquals("745896321", simpleClientInfoDTO.getPhoneNumber());
//    }
}