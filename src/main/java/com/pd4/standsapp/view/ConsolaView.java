package com.pd4.standsapp.view;

import com.pd4.standsapp.model.Mensaje;

import java.util.List;

/** Vista en consola: solo imprime, no tiene lógica de negocio ni acceso a BD. */
public class ConsolaView {

    public void mostrarMensaje(Mensaje mensaje) {
        System.out.println(mensaje);
    }

    public <T> void mostrarLista(String titulo, List<T> elementos) {
        System.out.println();
        System.out.println("=== " + titulo + " (" + elementos.size() + ") ===");
        if (elementos.isEmpty()) {
            System.out.println("(sin registros)");
            return;
        }
        elementos.forEach(e -> System.out.println("  " + e));
    }

    public void mostrarDato(String etiqueta, Object valor) {
        System.out.println("  " + etiqueta + ": " + valor);
    }
}
