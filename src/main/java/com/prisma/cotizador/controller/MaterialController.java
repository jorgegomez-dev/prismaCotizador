package com.prisma.cotizador.controller;

import com.prisma.cotizador.dto.MaterialDTO;
import com.prisma.cotizador.payload.ApiResponse;
import com.prisma.cotizador.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/materials")
public class MaterialController {

    private final MaterialService materialService;

    // Constructor Injection
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

//    @GetMapping()
//    public ResponseEntity<ApiResponse<HttpStatus>> isConnect(){
//        ApiResponse<HttpStatus> response = new ApiResponse<>(true, "Connection Succesful!", HttpStatus.OK);
//        return ResponseEntity.ok(response);
//    }

    @GetMapping("/listAll")
    public ResponseEntity<ApiResponse<List<MaterialDTO>>> getAllMaterials(){

            List<MaterialDTO> materials = materialService.getAllMaterials();
            ApiResponse<List<MaterialDTO>> response = new ApiResponse<>(true, "Materials fetched succeful", materials);
            return ResponseEntity.ok(response);
    }

    @GetMapping("/getMaterialById/{id}")
    public ResponseEntity<ApiResponse<MaterialDTO>> getMaterialById(@PathVariable Long id){
        MaterialDTO material = materialService.getMaterialById(id);
        ApiResponse<MaterialDTO> response = new ApiResponse<>(true, "Material found", material);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/createMaterial")
    public ResponseEntity<ApiResponse<MaterialDTO>> createMaterial(@RequestBody MaterialDTO material){
        materialService.createMaterial(material);
        ApiResponse<MaterialDTO> response = new ApiResponse<>(true, "Material created", material);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/updateMaterial/{id}")
    public ResponseEntity<ApiResponse<MaterialDTO>> updateMaterial(@PathVariable Long id,  @RequestBody MaterialDTO material){
        materialService.updateMaterial(id, material);
        ApiResponse<MaterialDTO> response = new ApiResponse<>(true, "Material updated!", material);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deleteMaterial/{id}")
    public ResponseEntity<ApiResponse<HttpStatus>> deleteMaterial(@PathVariable Long id){
        materialService.deleteMaterial(id);
        ApiResponse<HttpStatus> response = new ApiResponse<>(true, "Material deleted.", HttpStatus.OK);
        return ResponseEntity.ok(response);
    }
}
