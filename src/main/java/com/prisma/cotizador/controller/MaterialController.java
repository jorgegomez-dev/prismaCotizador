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
//    public ResponseEntity<?> isConnect(){
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping()
    public ResponseEntity<ApiResponse<HttpStatus>> isConnect(){
        ApiResponse<HttpStatus> response = new ApiResponse<>(true, "Connection Succesful!", HttpStatus.OK);
        return ResponseEntity.ok(response);
    }

//    @GetMapping("/listAll")
//    public ResponseEntity<List<MaterialDTO>> getAllMaterials(){
//        try {
//            return new ResponseEntity<>(materialService.getAllMaterials(), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    @GetMapping("/listAll")
    public ResponseEntity<ApiResponse<List<MaterialDTO>>> getAllMaterials(){

            List<MaterialDTO> materials = materialService.getAllMaterials();
            ApiResponse<List<MaterialDTO>> response = new ApiResponse<>(true, "Materials fetched succefull", materials);
            return ResponseEntity.ok(response);
    }

//    @GetMapping("/getMaterialById/{id}")
//    public ResponseEntity<?> getMaterialById(@PathVariable Long id){
//        try {
//            return new ResponseEntity<>(materialService.getMaterialById(id), HttpStatus.OK);
//        } catch (Exception e){
//            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Material Not Found");
//        }
//    }

    @GetMapping("/getMaterialById/{id}")
    public ResponseEntity<ApiResponse<MaterialDTO>> getMaterialById(@PathVariable Long id){
        MaterialDTO material = materialService.getMaterialById(id);
        ApiResponse<MaterialDTO> response = new ApiResponse<>(true, "Material found", material);
        return ResponseEntity.ok(response);
    }

//    @PostMapping("/createMaterial")
//    public ResponseEntity<?> createMaterial(@RequestBody MaterialDTO materialDTO){
//        try {
//            materialService.createMaterial(materialDTO);
//            return ResponseEntity.status(HttpStatus.CREATED).body("Material created");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The Material was not created");
//        }
//    }

    @PostMapping("/createMaterial")
    public ResponseEntity<ApiResponse<MaterialDTO>> createMaterial(@RequestBody MaterialDTO material){
        materialService.createMaterial(material);
        ApiResponse<MaterialDTO> response = new ApiResponse<>(true, "Material created", material);
        return ResponseEntity.ok(response);
    }

}
