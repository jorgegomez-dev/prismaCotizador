package com.prisma.cotizador.controller;

import com.prisma.cotizador.dto.UserDTO;
import com.prisma.cotizador.payload.ApiResponse;
import com.prisma.cotizador.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // Dependency
    private final UserService userService;

    // Constructor Injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/listAll")
    public ResponseEntity<ApiResponse<List<UserDTO>>> getAllUsers(){
        List<UserDTO> users = userService.getAllUsers();
        ApiResponse response = new ApiResponse<>(true, "Users fetched successful", users);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
