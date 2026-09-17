package com.prisma.cotizador.controller;

import com.prisma.cotizador.service.MaterialService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterialController {

    private final MaterialService materialService;

    // Constructor Injection
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }
}
