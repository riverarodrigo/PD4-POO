package com.pd4.standsapp.model;

import java.time.LocalDate;

/** Entidad de datos: Reservación de un stand por una editorial. */
public class Reservacion {
    private int id;
    private int standId;
    private int editorialId;
    private LocalDate fechaReserva;
    private String estado;

    // Datos de apoyo obtenidos con JOIN (solo lectura)
    private String standNumero;
    private String editorialNombre;

    public Reservacion(int id, int standId, int editorialId, LocalDate fechaReserva, String estado,
                       String standNumero, String editorialNombre) {
        this.id = id;
        this.standId = standId;
        this.editorialId = editorialId;
        this.fechaReserva = fechaReserva;
        this.estado = estado;
        this.standNumero = standNumero;
        this.editorialNombre = editorialNombre;
    }

    public int getId() { return id; }
    public int getStandId() { return standId; }
    public int getEditorialId() { return editorialId; }
    public LocalDate getFechaReserva() { return fechaReserva; }
    public String getEstado() { return estado; }
    public String getStandNumero() { return standNumero; }
    public String getEditorialNombre() { return editorialNombre; }

    @Override
    public String toString() {
        return String.format("Reservacion{id=%d, stand=%s, editorial=%s, fecha=%s, estado=%s}",
                id, standNumero, editorialNombre, fechaReserva, estado);
    }
}
