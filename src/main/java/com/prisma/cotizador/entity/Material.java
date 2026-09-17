package com.prisma.cotizador.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "materials")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Material;
    private String name;
    private String type;
    private String supplier;
    private Integer widthMM;
    private Integer heightMM;
    private String thicknessMM;
    private BigDecimal pricePesos; // Final price with tax and cutting saw service included

    // Variable for calculation of cutting time machine
    private Double speedCuttingMMS; // Speed cutting in millimeters per seconds

    // Stock dimensions of sheets
    private Integer stock90x60;
    private Integer stock60x60;
    private Integer stock60x45;
    private Integer stock60x30;
    private Integer stock30x30;
    private Integer stock100X50;
    private Integer stock50x50;

}
