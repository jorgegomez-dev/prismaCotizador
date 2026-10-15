package com.prisma.cotizador.service;

import com.prisma.cotizador.dto.ClientDTO;
import com.prisma.cotizador.entity.Client;

import java.util.List;

public interface ClientService {
    List<ClientDTO> getAllClients();

    ClientDTO getClientById(Long id);

    ClientDTO createClient(ClientDTO clientDTO);

    ClientDTO updateClient(Long id, ClientDTO clientDTO);

    void deleteClient(Long id);
}
