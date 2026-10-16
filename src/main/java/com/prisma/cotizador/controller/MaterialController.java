package com.prisma.cotizador.controller;

import com.prisma.cotizador.dto.MaterialDTO;
import com.prisma.cotizador.payload.ApiResponse;
import com.prisma.cotizador.service.MaterialService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/materials")
public class MaterialController {

    // Dependency
    private final MaterialService materialService;

    // Constructor Injection
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/listAll")
    public ResponseEntity<ApiResponse<List<MaterialDTO>>> getAllMaterials(){

        List<MaterialDTO> materials = materialService.getAllMaterials();
        ApiResponse<List<MaterialDTO>> response = new ApiResponse<>(true, "Materials fetched successful", materials);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getMaterialById/{id}")
    public ResponseEntity<ApiResponse<MaterialDTO>> getMaterialById(@PathVariable Long id){
        MaterialDTO material = materialService.getMaterialById(id);
        ApiResponse<MaterialDTO> response = new ApiResponse<>(true, "Material found", material);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @PostMapping("/createMaterial")
    public ResponseEntity<ApiResponse<MaterialDTO>> createMaterial(@Valid @RequestBody MaterialDTO material){
        materialService.createMaterial(material);
        ApiResponse<MaterialDTO> response = new ApiResponse<>(true, "Material created", material);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/updateMaterial/{id}")
    public ResponseEntity<ApiResponse<MaterialDTO>> updateMaterial(@PathVariable Long id, @Valid @RequestBody MaterialDTO material){
        materialService.updateMaterial(id, material);
        ApiResponse<MaterialDTO> response = new ApiResponse<>(true, "Material updated!", material);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/deleteMaterial/{id}")
    public ResponseEntity<ApiResponse<HttpStatus>> deleteMaterial(@PathVariable Long id){
        materialService.deleteMaterial(id);
        ApiResponse<HttpStatus> response = new ApiResponse<>(true, "Material deleted.", HttpStatus.OK);
        return ResponseEntity.ok(response);
    }
}
