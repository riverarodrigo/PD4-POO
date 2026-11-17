package com.pd4.standsapp.model;

import java.math.BigDecimal;

/** Entidad de datos: Stand de la feria. */
public class Stand {
    private int id;
    private String numero;
    private String ubicacion;
    private BigDecimal tamanoM2;
    private BigDecimal precio;

    public Stand(int id, String numero, String ubicacion, BigDecimal tamanoM2, BigDecimal precio) {
        this.id = id;
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.tamanoM2 = tamanoM2;
        this.precio = precio;
    }

    public int getId() { return id; }
    public String getNumero() { return numero; }
    public String getUbicacion() { return ubicacion; }
    public BigDecimal getTamanoM2() { return tamanoM2; }
    public BigDecimal getPrecio() { return precio; }

    @Override
    public String toString() {
        return String.format("Stand{id=%d, numero=%s, ubicacion=%s, tamano=%s m2, precio=$%s}",
                id, numero, ubicacion, tamanoM2, precio);
    }
}
