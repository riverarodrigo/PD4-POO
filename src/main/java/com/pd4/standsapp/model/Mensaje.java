package com.pd4.standsapp.model;

import java.time.LocalDateTime;

/** Entidad de datos: mensaje de la aplicación (estado de conexión, avisos, errores). */
public class Mensaje {
    public enum Tipo { INFO, EXITO, ERROR }

    private Tipo tipo;
    private String texto;
    private LocalDateTime fecha = LocalDateTime.now();

    public Mensaje(Tipo tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }

    public Tipo getTipo() { return tipo; }
    public String getTexto() { return texto; }
    public LocalDateTime getFecha() { return fecha; }

    @Override
    public String toString() {
        return "[" + tipo + "] " + texto;
    }
}
