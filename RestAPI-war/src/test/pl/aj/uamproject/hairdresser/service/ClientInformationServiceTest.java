package pl.aj.uamproject.hairdresser.service;

import org.junit.Test;
import pl.aj.uamproject.hairdresser.dto.SimpleClientInfoDTO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClientInformationServiceTest {

    private ClientInformationService clientInformationService = new ClientInformationService();

    @Test
    public void getAllClients() {
        List<SimpleClientInfoDTO> allClients = clientInformationService.getAllClients();
        assertEquals(5, allClients.size());

        SimpleClientInfoDTO simpleClientInfoDTO = allClients.stream().filter(it -> it.getId() == 1).findFirst().get();
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
        SimpleClientInfoDTO simpleClientInfoDTO = clientInformationService.getClientByLastName("Gajewski");
        assertEquals("Piotr", simpleClientInfoDTO.getFirstName());
        assertEquals("Gajewski", simpleClientInfoDTO.getLastName());
        assertEquals(4, simpleClientInfoDTO.getId());
        assertEquals("745896321", simpleClientInfoDTO.getPhoneNumber());
    }

    @Test
    public void getByPhoneNumber() {
        SimpleClientInfoDTO simpleClientInfoDTO = clientInformationService.getClientByPhoneNumber("745896321");
        assertEquals("Piotr", simpleClientInfoDTO.getFirstName());
        assertEquals("Gajewski", simpleClientInfoDTO.getLastName());
        assertEquals(4, simpleClientInfoDTO.getId());
        assertEquals("745896321", simpleClientInfoDTO.getPhoneNumber());
    }
}