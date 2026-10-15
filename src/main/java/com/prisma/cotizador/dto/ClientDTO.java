package com.prisma.cotizador.dto;

public record ClientDTO(
        Long id,
        String name,
        String surname,
        String company,
        String email,
        String phone
) {

}
