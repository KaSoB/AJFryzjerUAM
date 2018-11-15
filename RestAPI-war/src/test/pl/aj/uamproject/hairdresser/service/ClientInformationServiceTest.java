package pl.aj.uamproject.hairdresser.service;

import org.junit.Test;
import pl.aj.uamproject.hairdresser.dto.SimpleClientInfoDTO;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ClientInformationServiceTest {

    private ClientInformationService clientInformationService = new ClientInformationService();

    @Test
    public void getAllClients() {
        ArrayList<SimpleClientInfoDTO> allClients = clientInformationService.getAllClients();
        assertEquals(5, allClients.size());

        SimpleClientInfoDTO simpleClientInfoDTO = allClients.get(0);
        assertEquals("Jan", simpleClientInfoDTO.getFirstName());
        assertEquals("Kowalski", simpleClientInfoDTO.getLastName());
        assertEquals(1, simpleClientInfoDTO.getId());
        assertEquals("698488394", simpleClientInfoDTO.getPhoneNumber());
    }

    @Test
    public void getById() {
        SimpleClientInfoDTO simpleClientInfoDTO = clientInformationService.getClientById(1);
        assertEquals("Jan", simpleClientInfoDTO.getFirstName());
        assertEquals("Kowalski", simpleClientInfoDTO.getLastName());
        assertEquals(1, simpleClientInfoDTO.getId());
        assertEquals("698488394", simpleClientInfoDTO.getPhoneNumber());
    }

    @Test
    public void getByLastName() {
        SimpleClientInfoDTO simpleClientInfoDTO = allClients.getClientByLastName("Gajewski");
        assertEquals("Piotr", simpleClientInfoDTO.getFirstName());
        assertEquals("Gajewski", simpleClientInfoDTO.getLastName());
        assertEquals(4, simpleClientInfoDTO.getId());
        assertEquals("745896321", simpleClientInfoDTO.getPhoneNumber());
    }

    @Test
    public void getByPhoneNumber() {
        SimpleClientInfoDTO simpleClientInfoDTO = allClients.getClientByPhoneNumber("745896321");
        assertEquals("Piotr", simpleClientInfoDTO.getFirstName());
        assertEquals("Gajewski", simpleClientInfoDTO.getLastName());
        assertEquals(4, simpleClientInfoDTO.getId());
        assertEquals("745896321", simpleClientInfoDTO.getPhoneNumber());
    }
}