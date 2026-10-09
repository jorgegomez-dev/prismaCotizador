package com.prisma.cotizador.exception;

import com.prisma.cotizador.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //
    @ExceptionHandler(MaterialNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleMaterialNotFound(MaterialNotFoundException ex){
        ApiResponse<Void> response = new ApiResponse<>(false, ex.getMessage(), null);

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
