package com.prisma.cotizador.service.impl;

import com.prisma.cotizador.dto.ClientDTO;
import com.prisma.cotizador.service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    @Override
    public List<ClientDTO> getAllClients() {
        return List.of();
    }

    @Override
    public ClientDTO getClientById(Long id) {
        return null;
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
