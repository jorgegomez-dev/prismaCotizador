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
    private Integer stock100X50;
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
        this.stock100X50 = stock100X50;
        this.stock50x50 = stock50x50;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Material material = (Material) o;
        return getId_Material() != null && Objects.equals(getId_Material(), material.getId_Material());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
