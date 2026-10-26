package com.prisma.cotizador.service.impl;

import com.prisma.cotizador.dto.UserDTO;
import com.prisma.cotizador.entity.User;
import com.prisma.cotizador.exception.UserAlreadyExistException;
import com.prisma.cotizador.exception.UserNotFoundException;
import com.prisma.cotizador.repository.UserRepository;
import com.prisma.cotizador.service.UserService;

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

        return users.stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getName(),
                        user.getSurname(),
                        user.getUsername(),
                        user.getPassword(),
                        user.getRole()
                )).toList();
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return new UserDTO (
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getUsername(),
                user.getPassword(),
                user.getRole()
        );
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User(
                userDTO.id(),
                userDTO.name(),
                userDTO.surname(),
                userDTO.username(),
                userDTO.password(),
                userDTO.role()
        );

        // Block verify if exist another user in database with the same Name and Surname
        boolean alreadyExist =
                userRepository.existsByNameAndSurname(user.getName(), user.getSurname());

        if(alreadyExist){
            throw new UserAlreadyExistException(user.getName(), user.getSurname());
        }

        User userSaved = userRepository.save(user);

        return new UserDTO(
                userSaved.getId(),
                userSaved.getName(),
                userSaved.getSurname(),
                userSaved.getUsername(),
                userSaved.getPassword(),
                userSaved.getRole()
        );
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
