package com.prisma.cotizador.mapper;

import com.prisma.cotizador.dto.MaterialDTO;
import com.prisma.cotizador.entity.Material;

public class MaterialMapper {

    // private to prevent instantiation
    private MaterialMapper() {
    }

    public static MaterialDTO toDTO(Material material){
        return new MaterialDTO(
                material.getId(),
                material.getName(),
                material.getType(),
                material.getSupplier(),
                material.getWidthMM(),
                material.getHeightMM(),
                material.getThicknessMM(),
                material.getPricePesos(),
                material.getSpeedCuttingMMS(),
                material.getStock90x60(),
                material.getStock60x60(),
                material.getStock60x45(),
                material.getStock60x30(),
                material.getStock30x30(),
                material.getStock100x50(),
                material.getStock50x50()
        );
    }

    public static Material toEntity(MaterialDTO materialDTO){
        return new Material(
                materialDTO.id(),
                materialDTO.name(),
                materialDTO.type(),
                materialDTO.supplier(),
                materialDTO.widthMM(),
                materialDTO.heightMM(),
                materialDTO.thicknessMM(),
                materialDTO.pricePesos(),
                materialDTO.speedCuttingMMS(),
                materialDTO.stock90x60(),
                materialDTO.stock60x60(),
                materialDTO.stock60x45(),
                materialDTO.stock60x30(),
                materialDTO.stock30x30(),
                materialDTO.stock100x50(),
                materialDTO.stock50x50()
                );
    }
}
