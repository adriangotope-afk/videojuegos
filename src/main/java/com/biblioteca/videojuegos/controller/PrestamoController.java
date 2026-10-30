package com.biblioteca.videojuegos.controller;

import com.biblioteca.videojuegos.model.AlquilerRequest;
import com.biblioteca.videojuegos.service.PrestamoService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {
    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping("/alquilar")
    public Map<String, Object> alquilar(@RequestBody AlquilerRequest request) {
        return prestamoService.alquilar(request);
    }
}