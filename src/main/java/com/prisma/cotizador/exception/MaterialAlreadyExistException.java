package com.prisma.cotizador.exception;

public class MaterialAlreadyExistException extends IllegalArgumentException{

    public MaterialAlreadyExistException(String name, String type, String supplier, String thicknessMM){
        super("A material with the same name, type, supplier and thickness already exists.");}
}
