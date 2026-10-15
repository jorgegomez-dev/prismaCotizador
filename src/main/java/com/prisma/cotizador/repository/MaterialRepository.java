package com.prisma.cotizador.repository;

import com.prisma.cotizador.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long>{

    boolean existsByNameAndTypeAndSupplierAndThicknessMM(String name, String type, String supplier, String thicknessMM);
}
