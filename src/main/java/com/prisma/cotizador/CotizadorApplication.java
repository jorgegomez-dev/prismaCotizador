package com.prisma.cotizador;

import com.prisma.cotizador.entity.Material;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class CotizadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CotizadorApplication.class, args);
	}
		Material mat = new Material();

}
