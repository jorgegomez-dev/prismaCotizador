package com.prisma.cotizador.service.impl;

import com.prisma.cotizador.dto.UserDTO;
import com.prisma.cotizador.entity.User;
import com.prisma.cotizador.payload.ApiResponse;
import com.prisma.cotizador.repository.UserRepository;
import com.prisma.cotizador.service.UserService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserServiceImpl implements UserService {

    // Dependency to database access for the Service
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map(user -> new UserDTO(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getUsername(),
                user.getPassword(),
                user.getRole()
                )

        );

    }

    @Override
    public UserDTO getUserById(Long id) {
        return null;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
