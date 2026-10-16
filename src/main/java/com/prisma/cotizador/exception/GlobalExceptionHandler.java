package com.prisma.cotizador.exception;

import com.prisma.cotizador.payload.ApiResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // *** HANDLERS FOR MATERIALS ***
    // Handler 404 NOT FOUND for Material
    @ExceptionHandler(MaterialNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleMaterialNotFound(MaterialNotFoundException ex){
        ApiResponse<Void> response = new ApiResponse<>(false, ex.getMessage(), null);

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    // Handler 409 CONFLICT for Material
    @ExceptionHandler(MaterialAlreadyExistException.class)
    public ResponseEntity<ApiResponse<Void>> handleMaterialAlreadyExistException(MaterialAlreadyExistException ex){
        ApiResponse<Void> response = new ApiResponse<>(false, ex.getMessage(), null);

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }

    //-----------------------------------------------------------------
    // *** HANDLERS FOR CLIENTS ***

    // Handler 404 NOT FOUND for Client
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleClientNotFoundException(ClientNotFoundException ex){
        ApiResponse<Void> response = new ApiResponse<>(false, ex.getMessage(), null);

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    // Handler 409 CONFLICT for Client
    @ExceptionHandler(ClientAlreadyExistException.class)
    public ResponseEntity<ApiResponse<Void>> handlerClientAlreadyExistException(ClientAlreadyExistException ex){
        ApiResponse<Void> response = new ApiResponse<>(false, ex.getMessage(), null);

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(response);
    }

    // *** HANDLERS FOR ALL ***
    // Handle 400 BAD REQUEST for incomplete data to create or update Entities
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolation(
            ConstraintViolationException ex) {

        Map<String, String> errors = new HashMap<>();

        for (ConstraintViolation<?> violation :
                ex.getConstraintViolations()) {

            String field = violation.getPropertyPath().toString();
            String message = violation.getMessage();

            errors.put(field, message);
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }
}
