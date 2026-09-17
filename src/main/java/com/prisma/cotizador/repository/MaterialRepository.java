package com.prisma.cotizador.repository;

import com.prisma.cotizador.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MaterialRepository extends JpaRepository<Material, Long>{
}
