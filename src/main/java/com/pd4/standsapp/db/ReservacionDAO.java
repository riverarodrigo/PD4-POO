package com.pd4.standsapp.db;

import com.pd4.standsapp.model.Reservacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** Acceso a datos (JDBC) de la tabla reservacion (con JOIN a stand y editorial). Solo lectura. */
public class ReservacionDAO {

    public List<Reservacion> listarTodas() throws SQLException {
        String sql = "SELECT r.id, r.stand_id, r.editorial_id, r.fecha_reserva, r.estado, "
                   + "s.numero AS stand_numero, e.nombre AS editorial_nombre "
                   + "FROM reservacion r "
                   + "JOIN stand s ON s.id = r.stand_id "
                   + "JOIN editorial e ON e.id = r.editorial_id "
                   + "ORDER BY r.fecha_reserva";
        List<Reservacion> lista = new ArrayList<>();
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Reservacion(
                        rs.getInt("id"),
                        rs.getInt("stand_id"),
                        rs.getInt("editorial_id"),
                        rs.getDate("fecha_reserva").toLocalDate(),
                        rs.getString("estado"),
                        rs.getString("stand_numero"),
                        rs.getString("editorial_nombre")));
            }
        }
        return lista;
    }
}
