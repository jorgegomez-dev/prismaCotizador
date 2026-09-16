package com.prisma.cotizador.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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


//    @Override
//    public final boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null) return false;
//        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
//        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
//        if (thisEffectiveClass != oEffectiveClass) return false;
//        Material material = (Material) o;
//        return getId() != null && Objects.equals(getId(), material.getId());
//    }
//
//    @Override
//    public final int hashCode() {
//        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
//    }
}
