package com.prisma.cotizador.service.impl;

import com.prisma.cotizador.dto.MaterialDTO;
import com.prisma.cotizador.entity.Material;
import com.prisma.cotizador.repository.MaterialRepository;
import com.prisma.cotizador.service.MaterialService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    // Dependency to database access for the Service
    private final MaterialRepository materialRepository;

    // Constructor Injection
    public MaterialServiceImpl(MaterialRepository materialRepository){
        this.materialRepository = materialRepository;
    }

    @Override
    public List<MaterialDTO> getAllMaterials() {
        List<Material> materials = materialRepository.findAll();

        return materials.stream()
                .map(material -> new MaterialDTO(
                        material.getId_Material(),
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
                        material.getStock100X50(),
                        material.getStock50x50()
                ))
                .toList();
    }

    @Override
    public MaterialDTO getMaterialById(Long id) {
        Material material = materialRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Material not found"));

        return new MaterialDTO(
                material.getId_Material(),
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
                material.getStock100X50(),
                material.getStock50x50()
        );
    }

    @Override
    public MaterialDTO createMaterial(MaterialDTO materialDTO) {

        Material material = new Material(
                materialDTO.id_Material(),
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
                materialDTO.stock100X50(),
                materialDTO.stock50x50()
        );

        Material savedMaterial = materialRepository.save(material);

        return new MaterialDTO(
                savedMaterial.getId_Material(),
                savedMaterial.getName(),
                savedMaterial.getType(),
                savedMaterial.getSupplier(),
                savedMaterial.getWidthMM(),
                savedMaterial.getHeightMM(),
                savedMaterial.getThicknessMM(),
                savedMaterial.getPricePesos(),
                savedMaterial.getSpeedCuttingMMS(),
                savedMaterial.getStock90x60(),
                savedMaterial.getStock60x60(),
                savedMaterial.getStock60x45(),
                savedMaterial.getStock60x30(),
                savedMaterial.getStock30x30(),
                savedMaterial.getStock100X50(),
                savedMaterial.getStock50x50()
        );
    }

    @Override
    public MaterialDTO updateMaterial(Long id, MaterialDTO materialDTO) {
        Material material = materialRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Material not found"));

        material.setName(materialDTO.name());
        material.setType(materialDTO.type());
        material.setSupplier(materialDTO.supplier());
        material.setWidthMM(materialDTO.widthMM());
        material.setHeightMM(materialDTO.heightMM());
        material.setThicknessMM(materialDTO.thicknessMM());
        material.setPricePesos(materialDTO.pricePesos());
        material.setSpeedCuttingMMS(materialDTO.speedCuttingMMS());
        material.setStock90x60(materialDTO.stock90x60());
        material.setStock60x60(materialDTO.stock60x60());
        material.setStock60x45(materialDTO.stock60x45());
        material.setStock60x30(materialDTO.stock60x30());
        material.setStock30x30(materialDTO.stock30x30());
        material.setStock100X50(materialDTO.stock100X50());
        material.setStock50x50(materialDTO.stock50x50());

        Material updateMaterial = materialRepository.save(material);

        return new MaterialDTO(
                updateMaterial.getId_Material(),
                updateMaterial.getName(),
                updateMaterial.getType(),
                updateMaterial.getSupplier(),
                updateMaterial.getWidthMM(),
                updateMaterial.getHeightMM(),
                updateMaterial.getThicknessMM(),
                updateMaterial.getPricePesos(),
                updateMaterial.getSpeedCuttingMMS(),
                updateMaterial.getStock90x60(),
                updateMaterial.getStock60x60(),
                updateMaterial.getStock60x45(),
                updateMaterial.getStock60x30(),
                updateMaterial.getStock30x30(),
                updateMaterial.getStock100X50(),
                updateMaterial.getStock50x50()
        );
    }

    @Override
    public void deleteMaterial(Long id) {
            if(!materialRepository.existsById(id)){
                throw new RuntimeException("Material not found");
            }

            materialRepository.deleteById(id);
    }
}
