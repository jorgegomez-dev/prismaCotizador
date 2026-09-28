package com.prisma.cotizador.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

// This Standard API Response Wrapper let Controllers return explicit DTO objects
@Getter
@Setter
@ToString
public class ApiResponse <T>{
    private boolean success;
    private String message;
    private T data; //Here we will save DTOs, DTOs List, null or void data
    private LocalDateTime timeStamp = LocalDateTime.now();

    public ApiResponse() {
    }

    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ApiResponse<?> that = (ApiResponse<?>) o;
        return success == that.success && Objects.equals(message, that.message) && Objects.equals(data, that.data) && Objects.equals(timeStamp, that.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, message, data, timeStamp);
    }
}
