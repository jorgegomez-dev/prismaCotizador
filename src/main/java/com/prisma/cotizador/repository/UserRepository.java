package com.prisma.cotizador.repository;

import com.prisma.cotizador.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    boolean existsByNameAndSurname(String name, String surname);
}
