package com.pd4.standsapp.db;

import com.pd4.standsapp.model.Editorial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** Acceso a datos (JDBC) de la tabla editorial. Solo lectura. */
public class EditorialDAO {

    public List<Editorial> listarTodas() throws SQLException {
        String sql = "SELECT id, nombre, pais, email FROM editorial ORDER BY nombre";
        List<Editorial> lista = new ArrayList<>();
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Editorial(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("pais"),
                        rs.getString("email")));
            }
        }
        return lista;
    }
}
