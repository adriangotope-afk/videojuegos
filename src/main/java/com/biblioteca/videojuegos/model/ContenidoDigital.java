package com.biblioteca.videojuegos.model;

public abstract class ContenidoDigital {
    private Long id;
    private String titulo;
    private int anioLanzamiento;
    private double precioBase;
    private boolean disponible = true;

    public ContenidoDigital() {}

    public abstract double calcularPrecioRenta(int dias);

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public int getAnioLanzamiento() { return anioLanzamiento; }
    public void setAnioLanzamiento(int anioLanzamiento) { this.anioLanzamiento = anioLanzamiento; }
    public double getPrecioBase() { return precioBase; }
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}