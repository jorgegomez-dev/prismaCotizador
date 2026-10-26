package com.prisma.cotizador.exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String name, String surname) {
        super("A user with the same name and surname already exists.");
    }
}
