package com.prisma.cotizador;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(
		title = "Prisma Cotizador",
		version = "0.1",
		description = "API Rest for quotation of laser cutting C02 machine"
))

@SpringBootApplication
public class CotizadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CotizadorApplication.class, args);

//		Material material = new Material();
//		material.setName("MDF");
//		material.setThicknessMM("3");
//		material.setHeightMM(1830);
//		material.setWidthMM(2600);
//		material.setPricePesos(BigDecimal.valueOf(32560.50));
//		material.setType("Wood");
//		material.setSpeedCuttingMMS(25.0);
//		material.setStock30x30(0);
//		material.setStock60x30(1);
//		material.setStock90x60(8);
//		System.out.println(material);
	}

}
