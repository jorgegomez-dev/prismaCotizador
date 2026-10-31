package com.prisma.cotizador.mapper;

import com.prisma.cotizador.dto.UserDTO;
import com.prisma.cotizador.entity.User;

public class UserMapper {

    // private to prevent instantiation
    private UserMapper() {
    }

    public static UserDTO toDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getUsername(),
                user.getPassword(),
                user.getRole()
        );
    }

    public static User toEntity(UserDTO userDTO){
        return new User(
                userDTO.id(),
                userDTO.name(),
                userDTO.surname(),
                userDTO.username(),
                userDTO.password(),
                userDTO.role()
        );
    }
}
