package com.prisma.cotizador.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

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
    private Integer stock100x50;
    private Integer stock50x50;

    public Material() {
    }

    public Material(Long id_Material, String name, String type, String supplier, Integer widthMM, Integer heightMM, String thicknessMM, BigDecimal pricePesos, Double speedCuttingMMS, Integer stock90x60, Integer stock60x60, Integer stock60x45, Integer stock60x30, Integer stock30x30, Integer stock100X50, Integer stock50x50) {
        this.id_Material = id_Material;
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
        this.stock100x50 = stock100X50;
        this.stock50x50 = stock50x50;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Objects.equals(id_Material, material.id_Material) && Objects.equals(name, material.name) && Objects.equals(type, material.type) && Objects.equals(supplier, material.supplier) && Objects.equals(widthMM, material.widthMM) && Objects.equals(heightMM, material.heightMM) && Objects.equals(thicknessMM, material.thicknessMM) && Objects.equals(pricePesos, material.pricePesos) && Objects.equals(speedCuttingMMS, material.speedCuttingMMS) && Objects.equals(stock90x60, material.stock90x60) && Objects.equals(stock60x60, material.stock60x60) && Objects.equals(stock60x45, material.stock60x45) && Objects.equals(stock60x30, material.stock60x30) && Objects.equals(stock30x30, material.stock30x30) && Objects.equals(stock100x50, material.stock100x50) && Objects.equals(stock50x50, material.stock50x50);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Material, name, type, supplier, widthMM, heightMM, thicknessMM, pricePesos, speedCuttingMMS, stock90x60, stock60x60, stock60x45, stock60x30, stock30x30, stock100x50, stock50x50);
    }
}
