package com.pd4.standsapp;

import com.pd4.standsapp.controller.EditorialController;
import com.pd4.standsapp.controller.ReservacionController;
import com.pd4.standsapp.controller.StandController;
import com.pd4.standsapp.db.ConexionBD;
import com.pd4.standsapp.model.Mensaje;
import com.pd4.standsapp.view.ConsolaView;

import java.sql.SQLException;

/** Punto de entrada: demuestra la conexión a la BD y lista las 3 tablas. */
public class Main {

    public static void main(String[] args) {
        ConsolaView vista = new ConsolaView();

        // 1) Probar conexión a la BD
        if (!ConexionBD.probarConexion()) {
            vista.mostrarMensaje(new Mensaje(Mensaje.Tipo.ERROR,
                    "No se pudo conectar a la BD: " + ConexionBD.getUrl()));
            return;
        }
        vista.mostrarMensaje(new Mensaje(Mensaje.Tipo.EXITO,
                "Conexión a la BD exitosa: " + ConexionBD.getUrl()));

        // 2) Controladores (lógica de negocio)
        StandController standCtrl = new StandController();
        EditorialController editorialCtrl = new EditorialController();
        ReservacionController reservacionCtrl = new ReservacionController();

        // 3) Leer y presentar cada tabla
        try {
            vista.mostrarLista("STANDS", standCtrl.listarStands());
            vista.mostrarLista("EDITORIALES", editorialCtrl.listarEditoriales());
            vista.mostrarLista("RESERVACIONES", reservacionCtrl.listarReservaciones());

            // Ejemplos de lógica de negocio en los controladores
            System.out.println();
            System.out.println("=== Lógica de negocio ===");
            vista.mostrarDato("Ingreso potencial de stands", "$" + standCtrl.ingresoPotencial());
            vista.mostrarDato("Editoriales de España", editorialCtrl.listarPorPais("España").size());
            vista.mostrarDato("Reservaciones confirmadas", reservacionCtrl.listarConfirmadas().size());
        } catch (SQLException e) {
            vista.mostrarMensaje(new Mensaje(Mensaje.Tipo.ERROR, "Error leyendo la BD: " + e.getMessage()));
        }
    }
}
