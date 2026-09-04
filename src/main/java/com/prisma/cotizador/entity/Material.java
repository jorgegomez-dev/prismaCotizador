package com.prisma.cotizador.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name= "material")
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
