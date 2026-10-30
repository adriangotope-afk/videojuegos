package com.biblioteca.videojuegos.controller;

import com.biblioteca.videojuegos.model.ContenidoDigital;
import com.biblioteca.videojuegos.model.JuegoDigital;
import com.biblioteca.videojuegos.model.JuegoFisico;
import com.biblioteca.videojuegos.service.JuegoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/juegos")
public class JuegoController {
    private final JuegoService juegoService;

    public JuegoController(JuegoService juegoService) {
        this.juegoService = juegoService;
    }

    @PostMapping("/fisico")
    public ContenidoDigital registrarFisico(@RequestBody JuegoFisico juego) {
        return juegoService.registrar(juego);
    }

    @PostMapping("/digital")
    public ContenidoDigital registrarDigital(@RequestBody JuegoDigital juego) {
        return juegoService.registrar(juego);
    }

    @GetMapping
    public List<ContenidoDigital> listarDisponibles() {
        return juegoService.listarDisponibles();
    }
}