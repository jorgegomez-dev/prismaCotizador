package com.prisma.cotizador.dto;

import java.math.BigDecimal;

public record MaterialDTO(
        Long id_Material,
        String name,
        String type,
        String supplier,
        Integer widthMM,
        Integer heightMM,
        String thicknessMM,
        BigDecimal pricePesos, // Final price with tax and cutting saw service included

        // Variable for calculation of cutting time machine
        Double speedCuttingMMS, // Speed cutting in millimeters per seconds

        // Stock dimensions of sheets
        Integer stock90x60,
        Integer stock60x60,
        Integer stock60x45,
        Integer stock60x30,
        Integer stock30x30,
        Integer stock100x50,
        Integer stock50x50
) {

}
