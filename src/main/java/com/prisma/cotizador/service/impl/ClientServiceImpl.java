package com.prisma.cotizador.service.impl;

import com.prisma.cotizador.dto.ClientDTO;
import com.prisma.cotizador.entity.Client;
import com.prisma.cotizador.exception.ClientAlreadyExistException;
import com.prisma.cotizador.exception.ClientNotFoundException;
import com.prisma.cotizador.repository.ClientRepository;
import com.prisma.cotizador.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    // Dependency to database access for the Service
    private final ClientRepository clientRepository;

    // Constructor Injection
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream()
                .map(client -> new ClientDTO(
                        client.getId(),
                        client.getName(),
                        client.getSurname(),
                        client.getCompany(),
                        client.getEmail(),
                        client.getPhone()
                )).toList();
    }

    @Override
    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        return new ClientDTO(
                client.getId(),
                client.getName(),
                client.getSurname(),
                client.getCompany(),
                client.getEmail(),
                client.getPhone()
        );
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = new Client(
                clientDTO.id(),
                clientDTO.name(),
                clientDTO.surname(),
                clientDTO.company(),
                clientDTO.email(),
                clientDTO.phone()
        );

        // Block verify if exist another client in database with the same Name, Type,  Supplier & Thickness
        boolean alreadyExist =
                clientRepository.existsByNameAndSurnameAndEmail(
                        client.getName(),
                        client.getSurname(),
                        client.getEmail()
                );

        if(alreadyExist){
            throw new ClientAlreadyExistException(clientDTO.name(), clientDTO.surname(), clientDTO.email());
        }

        Client savedClient = clientRepository.save(client);

        return new ClientDTO(
                savedClient.getId(),
                savedClient.getName(),
                savedClient.getSurname(),
                savedClient.getCompany(),
                savedClient.getEmail(),
                savedClient.getPhone()
        );
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        client.setName(clientDTO.name());
        client.setSurname(clientDTO.surname());
        client.setCompany(clientDTO.company());
        client.setEmail(clientDTO.email());
        client.setPhone(clientDTO.phone());

        Client updatedClient = clientRepository.save(client);

        return new ClientDTO(
                updatedClient.getId(),
                updatedClient.getName(),
                updatedClient.getSurname(),
                updatedClient.getCompany(),
                updatedClient.getEmail(),
                updatedClient.getPhone()
        );
    }

    @Override
    public void deleteClient(Long id) {
        if(!clientRepository.existsById(id)){
            throw new ClientNotFoundException(id);
        }

        clientRepository.deleteById(id);
    }
}
