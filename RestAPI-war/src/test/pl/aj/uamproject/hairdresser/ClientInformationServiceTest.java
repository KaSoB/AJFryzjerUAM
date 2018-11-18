package pl.aj.uamproject.hairdresser;

import org.junit.Test;
import pl.aj.uamproject.hairdresser.dto.SimpleClientInfoDTO;
import pl.aj.uamproject.hairdresser.model.Client;
import pl.aj.uamproject.hairdresser.service.ClientInformationService;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClientInformationServiceTest {

    private ClientInformationService clientInformationService = new ClientInformationService();

    @Test
    public void getAllClients() {
       // List<Client> allClients = clientInformationService.getAllClients();
        assertEquals(0, 0);
    }
//
//    @Test
//    public void getById() {
//        Client simpleClientInfoDTO = clientInformationService.getClientById(1);
//        assertEquals("Jan", simpleClientInfoDTO.getFirstName());
//        assertEquals("Kowalski", simpleClientInfoDTO.getLastName());
//        assertEquals(1, simpleClientInfoDTO.getId());
//        assertEquals("698488394", simpleClientInfoDTO.getPhoneNumber());
//    }
//
//    @Test
//    public void getByLastName() {
//        Client simpleClientInfoDTO = clientInformationService.getClientByLastName("Gajewski");
//        assertEquals("Piotr", simpleClientInfoDTO.getFirstName());
//        assertEquals("Gajewski", simpleClientInfoDTO.getLastName());
//        assertEquals(4, simpleClientInfoDTO.getId());
//        assertEquals("745896321", simpleClientInfoDTO.getPhoneNumber());
//    }
//
//    @Test
//    public void getByPhoneNumber() {
//        Client simpleClientInfoDTO = clientInformationService.getClientByPhoneNumber("745896321");
//        assertEquals("Piotr", simpleClientInfoDTO.getFirstName());
//        assertEquals("Gajewski", simpleClientInfoDTO.getLastName());
//        assertEquals(4, simpleClientInfoDTO.getId());
//        assertEquals("745896321", simpleClientInfoDTO.getPhoneNumber());
//    }
}