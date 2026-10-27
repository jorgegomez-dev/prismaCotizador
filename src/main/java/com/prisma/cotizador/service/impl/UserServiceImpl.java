package com.prisma.cotizador.service.impl;

import com.prisma.cotizador.dto.UserDTO;
import com.prisma.cotizador.entity.User;
import com.prisma.cotizador.exception.UserAlreadyExistException;
import com.prisma.cotizador.exception.UserNotFoundException;
import com.prisma.cotizador.mapper.UserMapper;
import com.prisma.cotizador.repository.UserRepository;
import com.prisma.cotizador.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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

        return UserMapper.toDTO(user);

    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = UserMapper.toEntity(userDTO);

        // Block verify if exist another user in database with the same Name and Surname
        boolean alreadyExist =
                userRepository.existsByNameAndSurname(user.getName(), user.getSurname());

        if(alreadyExist){
            throw new UserAlreadyExistException(user.getName(), user.getSurname());
        }

        User userSaved = userRepository.save(user);

        return UserMapper.toDTO(userSaved);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).
                orElseThrow(()-> new UserNotFoundException(id));

        user.setId(userDTO.id());
        user.setName(userDTO.name());
        user.setSurname(userDTO.surname());
        user.setUsername(userDTO.username());
        user.setPassword(userDTO.password());
        user.setRole(userDTO.role());

        User userUpdated = userRepository.save(user);

        return UserMapper.toDTO(userUpdated);
    }

    @Override
    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }
}
