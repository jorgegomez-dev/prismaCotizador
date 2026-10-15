package com.prisma.cotizador.repository;

import com.prisma.cotizador.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>{
}
