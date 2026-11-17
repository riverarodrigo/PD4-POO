package com.pd4.standsapp.db;

import com.pd4.standsapp.model.Stand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** Acceso a datos (JDBC) de la tabla stand. Solo lectura. */
public class StandDAO {

    public List<Stand> listarTodos() throws SQLException {
        String sql = "SELECT id, numero, ubicacion, tamano_m2, precio FROM stand ORDER BY numero";
        List<Stand> lista = new ArrayList<>();
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Stand(
                        rs.getInt("id"),
                        rs.getString("numero"),
                        rs.getString("ubicacion"),
                        rs.getBigDecimal("tamano_m2"),
                        rs.getBigDecimal("precio")));
            }
        }
        return lista;
    }
}
