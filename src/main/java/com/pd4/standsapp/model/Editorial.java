package com.pd4.standsapp.model;

/** Entidad de datos: Editorial que participa en la feria. */
public class Editorial {
    private int id;
    private String nombre;
    private String pais;
    private String email;

    public Editorial(int id, String nombre, String pais, String email) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.email = email;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPais() { return pais; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return String.format("Editorial{id=%d, nombre=%s, pais=%s, email=%s}", id, nombre, pais, email);
    }
}
