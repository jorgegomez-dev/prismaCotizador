package com.prisma.cotizador.service.impl;

import com.prisma.cotizador.dto.ClientDTO;
import com.prisma.cotizador.entity.Client;
import com.prisma.cotizador.exception.ClientNotFoundException;
import com.prisma.cotizador.repository.ClientRepository;
import com.prisma.cotizador.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    // Dependency to database access for the Service
    private final ClientRepository clientRepository;

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
        return null;
    }

    @Override
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        return null;
    }

    @Override
    public void deleteClient(Long id) {

    }
}
