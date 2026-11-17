package com.pd4.standsapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Capa de base de datos: fábrica de conexiones JDBC.
 * Configurable con variables de entorno DB_URL, DB_USER y DB_PASSWORD.
 */
public final class ConexionBD {

    private static final String URL = env("DB_URL",
            "jdbc:mysql://localhost:3306/ferialibro?useSSL=false&allowPublicKeyRetrieval=true");
    private static final String USER = env("DB_USER", "root");
    private static final String PASSWORD = env("DB_PASSWORD", "root1234");

    private ConexionBD() { }

    private static String env(String clave, String valorPorDefecto) {
        String valor = System.getenv(clave);
        return (valor == null || valor.isBlank()) ? valorPorDefecto : valor;
    }

    /** Abre una conexión nueva. Quien la use debe cerrarla (try-with-resources). */
    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /** Verifica que sea posible conectarse a la BD. */
    public static boolean probarConexion() {
        try (Connection c = getConexion()) {
            return c.isValid(3);
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            return false;
        }
    }

    public static String getUrl() { return URL; }
}
