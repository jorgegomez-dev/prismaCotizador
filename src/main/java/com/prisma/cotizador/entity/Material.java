package com.prisma.cotizador.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "materials")
@Getter
@Setter
@ToString
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The name is required")
    private String name;

    @NotBlank(message = "The type is required")
    private String type;

    @NotBlank(message = "The supplier is required")
    private String supplier;

    @NotNull(message = "The width is required")
    @Positive(message = "The width must be greater than zero")
    private Integer widthMM;

    @NotNull(message = "The height is required")
    @Positive(message = "The height must be greater than zero")
    private Integer heightMM;

    @NotBlank(message = "The thickness is required")
    private String thicknessMM;

    @NotNull(message = "The price is required")
    @Positive(message = "The price must be greater than zero")
    private BigDecimal pricePesos; // Final price with tax and cutting saw service included

    // Variable for calculation of cutting time machine
    @NotNull(message = "The speed cutting is required")
    @Positive(message = "The speed cutting must be greater than zero")
    private Double speedCuttingMMS; // Speed cutting in millimeters per seconds

    // Stock dimensions of sheets
    @NotNull(message = "The quantity is required")
    @PositiveOrZero(message = "The quantity must be zero or greater than zero")
    private Integer stock90x60;

    @NotNull(message = "The quantity is required")
    @PositiveOrZero(message = "The quantity must be zero or greater than zero")
    private Integer stock60x60;

    @NotNull(message = "The quantity is required")
    @PositiveOrZero(message = "The quantity must be zero or greater than zero")
    private Integer stock60x45;

    @NotNull(message = "The quantity is required")
    @PositiveOrZero(message = "The quantity must be zero or greater than zero")
    private Integer stock60x30;

    @NotNull(message = "The quantity is required")
    @PositiveOrZero(message = "The quantity must be zero or greater than zero")
    private Integer stock30x30;

    @NotNull(message = "The quantity is required")
    @PositiveOrZero(message = "The quantity must be zero or greater than zero")
    private Integer stock100x50;

    @NotNull(message = "The quantity is required")
    @PositiveOrZero(message = "The quantity must be zero or greater than zero")
    private Integer stock50x50;

    public Material() {
    }

    public Material(Long id, String name, String type, String supplier, Integer widthMM, Integer heightMM, String thicknessMM, BigDecimal pricePesos, Double speedCuttingMMS, Integer stock90x60, Integer stock60x60, Integer stock60x45, Integer stock60x30, Integer stock30x30, Integer stock100x50, Integer stock50x50) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.supplier = supplier;
        this.widthMM = widthMM;
        this.heightMM = heightMM;
        this.thicknessMM = thicknessMM;
        this.pricePesos = pricePesos;
        this.speedCuttingMMS = speedCuttingMMS;
        this.stock90x60 = stock90x60;
        this.stock60x60 = stock60x60;
        this.stock60x45 = stock60x45;
        this.stock60x30 = stock60x30;
        this.stock30x30 = stock30x30;
        this.stock100x50 = stock100x50;
        this.stock50x50 = stock50x50;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Objects.equals(id, material.id) && Objects.equals(name, material.name) && Objects.equals(type, material.type) && Objects.equals(supplier, material.supplier) && Objects.equals(widthMM, material.widthMM) && Objects.equals(heightMM, material.heightMM) && Objects.equals(thicknessMM, material.thicknessMM) && Objects.equals(pricePesos, material.pricePesos) && Objects.equals(speedCuttingMMS, material.speedCuttingMMS) && Objects.equals(stock90x60, material.stock90x60) && Objects.equals(stock60x60, material.stock60x60) && Objects.equals(stock60x45, material.stock60x45) && Objects.equals(stock60x30, material.stock60x30) && Objects.equals(stock30x30, material.stock30x30) && Objects.equals(stock100x50, material.stock100x50) && Objects.equals(stock50x50, material.stock50x50);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, supplier, widthMM, heightMM, thicknessMM, pricePesos, speedCuttingMMS, stock90x60, stock60x60, stock60x45, stock60x30, stock30x30, stock100x50, stock50x50);
    }
}
