package com.prisma.cotizador.controller;

import com.prisma.cotizador.dto.UserDTO;
import com.prisma.cotizador.payload.ApiResponse;
import com.prisma.cotizador.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> getUserById(@PathVariable Long id){
        UserDTO user = userService.getUserById(id);
        ApiResponse<UserDTO> response = new ApiResponse<>(true, "User Found", user);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/createUser")
    public ResponseEntity<ApiResponse<UserDTO>> createUser(@Valid @RequestBody UserDTO userDTO){
        UserDTO user = userService.createUser(userDTO);
        ApiResponse<UserDTO> response = new ApiResponse<>(true, "User created", user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO){
        UserDTO user = userService.updateUser(id, userDTO);
        ApiResponse<UserDTO> response = new ApiResponse<>(true, "User updated", user);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<ApiResponse<HttpStatus>> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        ApiResponse<HttpStatus> response = new ApiResponse<>(true, "User deleted", HttpStatus.OK);
        return ResponseEntity.ok(response);

    }

}
