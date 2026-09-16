package com.prisma.cotizador;

import com.prisma.cotizador.entity.Material;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;

import java.math.BigDecimal;

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
