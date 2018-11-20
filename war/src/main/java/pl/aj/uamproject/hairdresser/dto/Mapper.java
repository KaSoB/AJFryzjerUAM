package pl.aj.uamproject.hairdresser.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import pl.aj.uamproject.hairdresser.model.Client;

import java.util.Arrays;
import java.util.List;


public class Mapper {
    private ModelMapper modelMapper = new ModelMapper();

    public List<ClientDTO> ClientToClientDTO(List<Client> items){
        return modelMapper.map(items, new TypeToken<List<ClientDTO>>(){}.getType());
    }
    public ClientDTO ClientToClientDTO(Client item){
        return modelMapper.map(item, ClientDTO.class);
    }
    public List<Client> ClientDTOToClient(List<ClientDTO> items){
        return modelMapper.map(items, new TypeToken<List<Client>>(){}.getType());
    }
    public Client ClientDTOToClient(ClientDTO item){
        return modelMapper.map(item, Client.class);
    }
}


