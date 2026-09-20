package com.prisma.cotizador.controller;

import com.prisma.cotizador.dto.MaterialDTO;
import com.prisma.cotizador.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/materials")
public class MaterialController {

    private final MaterialService materialService;

    // Constructor Injection
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/listAll")
    public ResponseEntity<?> getAllMaterials(){

        try {
            return new ResponseEntity<>(materialService.getAllMaterials(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getMaterialById{id}")
    public ResponseEntity<?> getMaterialById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(materialService.getMaterialById(id), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
