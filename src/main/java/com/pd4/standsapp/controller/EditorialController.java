package com.pd4.standsapp.controller;

import com.pd4.standsapp.db.EditorialDAO;
import com.pd4.standsapp.model.Editorial;

import java.sql.SQLException;
import java.util.List;

/** Lógica de negocio de Editoriales. */
public class EditorialController {
    private final EditorialDAO dao = new EditorialDAO();

    public List<Editorial> listarEditoriales() throws SQLException {
        return dao.listarTodas();
    }

    /** Regla de negocio: filtrar editoriales por país. */
    public List<Editorial> listarPorPais(String pais) throws SQLException {
        return dao.listarTodas().stream()
                .filter(e -> e.getPais().equalsIgnoreCase(pais))
                .toList();
    }
}
