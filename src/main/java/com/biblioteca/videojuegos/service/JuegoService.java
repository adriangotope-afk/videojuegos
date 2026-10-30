package com.biblioteca.videojuegos.service;

import com.biblioteca.videojuegos.model.ContenidoDigital;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class JuegoService {
    private final List<ContenidoDigital> juegos = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    public ContenidoDigital registrar(ContenidoDigital juego) {
        juego.setId(contador.getAndIncrement());
        juego.setDisponible(true);
        juegos.add(juego);
        return juego;
    }

    public List<ContenidoDigital> listarDisponibles() {
        return juegos.stream().filter(ContenidoDigital::isDisponible).toList();
    }

    public ContenidoDigital buscarPorId(Long id) {
        return juegos.stream()
                .filter(j -> j.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Juego no encontrado: " + id));
    }
}