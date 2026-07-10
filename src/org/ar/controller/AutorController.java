package org.ar.controller;

import otg.ar.dao.AutorDAO;
import org.ar.dao.imp.AutorDAOImpl;
import org.ar.view.AutorConsoleView;

public class AutorController {

    private final AutorDAO dao;
    private final AutorConsoleView vista;

    public AutorController(AutorConsoleView vista) {
        this.dao = new AutorDAOImpl();
        this.vista = vista;
    }

    public void iniciar() {

        int opcion;

        do {

            opcion = vista.mostrarMenu();

            if (opcion == 2) {
                listar();
            }

        } while (opcion != 6);
    }

    private void listar() {
        vista.mostrarListaAutores(dao.listarTodos());
    }
}
