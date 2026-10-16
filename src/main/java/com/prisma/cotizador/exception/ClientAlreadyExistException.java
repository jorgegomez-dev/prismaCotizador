package com.prisma.cotizador.exception;

public class ClientAlreadyExistException extends RuntimeException {
    public ClientAlreadyExistException(String name, String surname, String email) {
        super("A client with the same name, surname and email already exists.");
    }
}
