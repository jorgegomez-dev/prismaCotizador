package com.prisma.cotizador.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String supplier;
    private Double widthMM;
    private Double heightMM;
    private Double thicknessMM;
    private BigDecimal pricePesos;

}
