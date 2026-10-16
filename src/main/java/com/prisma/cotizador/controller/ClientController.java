package com.prisma.cotizador.controller;

import com.prisma.cotizador.dto.ClientDTO;
import com.prisma.cotizador.payload.ApiResponse;
import com.prisma.cotizador.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    // Dependency
    private final ClientService clientService;

    // Constructor Injection
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/listAll")
    public ResponseEntity<ApiResponse<List<ClientDTO>>> getAllClients(){
        List<ClientDTO> clients = clientService.getAllClients();
        ApiResponse<List<ClientDTO>> response = new ApiResponse<>(true, "Clients fetched successful", clients);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getClientById/{id}")
    public ResponseEntity<ApiResponse<ClientDTO>> getClientById(@PathVariable Long id){
        ClientDTO client = clientService.getClientById(id);
        ApiResponse<ClientDTO> response = new ApiResponse<>(true, "Client Found.", client);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/createClient")
    public ResponseEntity<ApiResponse<ClientDTO>> createClient(@Valid @RequestBody ClientDTO clientDTO){
        ClientDTO client = clientService.createClient(clientDTO);
        ApiResponse<ClientDTO> response = new ApiResponse<>(true, "Client created", client);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("updateClient/{id}")
    public ResponseEntity<ApiResponse<ClientDTO>> updateClient(@PathVariable Long id, @Valid @RequestBody ClientDTO client){
        clientService.updateClient(id, client);
        ApiResponse<ClientDTO> response = new ApiResponse<>(true, "Client updated", client);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("deleteClient/{id}")
    public ResponseEntity<ApiResponse<HttpStatus>> deleteClient (@PathVariable Long id){
        clientService.deleteClient(id);
        ApiResponse<HttpStatus> response = new ApiResponse<>(true, "Client deleted.", HttpStatus.OK);
        return ResponseEntity.ok(response);
    }
}
