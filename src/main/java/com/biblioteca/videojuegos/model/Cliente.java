package com.biblioteca.videojuegos.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public static final int LIMITE_JUEGOS = 3;

    private Long id;
    private String nombre;
    private String email;
    private List<ContenidoDigital> juegosPrestados = new ArrayList<>();

    public Cliente() {}

    public boolean puedeAlquilar() {
        return juegosPrestados.size() < LIMITE_JUEGOS;
    }

    public void agregarJuego(ContenidoDigital juego) {
        if (!puedeAlquilar()) {
            throw new IllegalStateException("El cliente ya tiene 3 juegos alquilados");
        }
        juegosPrestados.add(juego);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<ContenidoDigital> getJuegosPrestados() { return juegosPrestados; }
}