package com.biblioteca.videojuegos.model;

public class JuegoFisico extends ContenidoDigital {
    private double pesoGramos;

    public JuegoFisico() {}

    public double getPesoGramos() { return pesoGramos; }
    public void setPesoGramos(double pesoGramos) { this.pesoGramos = pesoGramos; }

    @Override
    public double calcularPrecioRenta(int dias) {
        return (getPrecioBase() * dias) + 2.00; // recargo fijo por envío
    }
}