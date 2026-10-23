package com.prisma.cotizador.dto;

public record UserDTO(
        Long id,
        String name,
        String surname,
        String username,
        String password,
        String role
) {
}
