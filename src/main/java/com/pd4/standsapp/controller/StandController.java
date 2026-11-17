package com.pd4.standsapp.controller;

import com.pd4.standsapp.db.StandDAO;
import com.pd4.standsapp.model.Stand;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

/** Lógica de negocio de Stands. */
public class StandController {
    private final StandDAO dao = new StandDAO();

    public List<Stand> listarStands() throws SQLException {
        return dao.listarTodos();
    }

    /** Regla de negocio: stands ordenados del más barato al más caro. */
    public List<Stand> listarPorPrecio() throws SQLException {
        List<Stand> stands = dao.listarTodos();
        stands.sort(Comparator.comparing(Stand::getPrecio));
        return stands;
    }

    /** Regla de negocio: ingreso potencial si se vendieran todos los stands. */
    public BigDecimal ingresoPotencial() throws SQLException {
        return dao.listarTodos().stream()
                .map(Stand::getPrecio)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
