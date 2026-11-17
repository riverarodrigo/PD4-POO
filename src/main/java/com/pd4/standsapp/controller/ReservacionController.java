package com.pd4.standsapp.controller;

import com.pd4.standsapp.db.ReservacionDAO;
import com.pd4.standsapp.model.Reservacion;

import java.sql.SQLException;
import java.util.List;

/** Lógica de negocio de Reservaciones. */
public class ReservacionController {
    private final ReservacionDAO dao = new ReservacionDAO();

    public List<Reservacion> listarReservaciones() throws SQLException {
        return dao.listarTodas();
    }

    /** Regla de negocio: solo reservaciones confirmadas. */
    public List<Reservacion> listarConfirmadas() throws SQLException {
        return dao.listarTodas().stream()
                .filter(r -> "CONFIRMADA".equalsIgnoreCase(r.getEstado()))
                .toList();
    }

    /** Regla de negocio: cuántas reservaciones hay en un estado dado. */
    public long contarPorEstado(String estado) throws SQLException {
        return dao.listarTodas().stream()
                .filter(r -> estado.equalsIgnoreCase(r.getEstado()))
                .count();
    }
}
