package com.biblioteca.videojuegos.model;

public record AlquilerRequest(Long clienteId, Long juegoId, int dias) {}