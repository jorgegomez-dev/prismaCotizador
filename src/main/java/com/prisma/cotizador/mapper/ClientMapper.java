package com.prisma.cotizador.mapper;

import com.prisma.cotizador.dto.ClientDTO;
import com.prisma.cotizador.entity.Client;

public class ClientMapper {

    // private to prevent instantation
    private ClientMapper() {
    }

    public static ClientDTO toDTO(Client client){
        return new ClientDTO(
                client.getId(),
                client.getName(),
                client.getSurname(),
                client.getCompany(),
                client.getEmail(),
                client.getPhone()
        );
    }

    public static Client toEntity(ClientDTO clientDTO){
        return new Client(
                clientDTO.id(),
                clientDTO.name(),
                clientDTO.surname(),
                clientDTO.company(),
                clientDTO.email(),
                clientDTO.phone()
        );
    }
}
