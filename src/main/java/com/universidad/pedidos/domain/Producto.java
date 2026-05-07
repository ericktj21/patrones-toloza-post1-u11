package com.universidad.pedidos.domain;

public class Producto {
    private Long id;
    private double precio;

    public Producto() {
    }

    public Producto(Long id, double precio) {
        this.id = id;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }
}
