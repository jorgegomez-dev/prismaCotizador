package com.prisma.cotizador.exception;

public class MaterialNotFoundException extends RuntimeException{

    public MaterialNotFoundException(Long id){
        super("Material not found with id: " + id);
    }
}
