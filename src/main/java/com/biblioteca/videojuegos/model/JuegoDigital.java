package com.biblioteca.videojuegos.model;

public class JuegoDigital extends ContenidoDigital {
    private double tamanoGB;

    public JuegoDigital() {}

    public double getTamanoGB() { return tamanoGB; }
    public void setTamanoGB(double tamanoGB) { this.tamanoGB = tamanoGB; }

    @Override
    public double calcularPrecioRenta(int dias) {
        double total = getPrecioBase() * dias;
        if (tamanoGB > 50) {
            total = total * 0.90; // descuento del 10%
        }
        return total;
    }
}