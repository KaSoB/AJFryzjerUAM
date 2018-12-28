package pl.aj.uamproject.hairdresser.dto;


import pl.aj.uamproject.hairdresser.dao.EmployeeDAO;
import pl.aj.uamproject.hairdresser.model.Client;
import pl.aj.uamproject.hairdresser.model.Employee;

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
    public EmployeeDTO EmployeeToEmployeeDTO(Employee employee){
        return new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName());
    }
    public Employee EmployeeDTOToEmployee(EmployeeDTO employee){
        return new Employee(employee.getId(), employee.getFirstName(), employee.getLastName());
    }
    public List<EmployeeDTO> EmployeeToEmployeeDTO(List<Employee> items){
        List<EmployeeDTO> result = new ArrayList<>();
        items.forEach(it -> result.add(EmployeeToEmployeeDTO(it)));
        return result;
    }
    public List<Employee> EmployeeDTOToEmployee(List<EmployeeDTO> items){
        List<Employee> result = new ArrayList<>();
        items.forEach(it -> result.add(EmployeeDTOToEmployee(it)));
        return result;
    }
}


