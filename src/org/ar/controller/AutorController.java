package org.ar.controller;

import otg.ar.dao.AutorDAO;
import org.ar.dao.imp.AutorDAOImpl;
import org.ar.model.Autor;
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

            switch (opcion) {
                case 1:
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    buscar();
                    break;

                case 4:
                    break;
            }

        } while (opcion != 0);
    }

    private void listar() {
        vista.mostrarListaAutor(dao.listarTodos());
    }

    private void buscar() {
        int id = vista.solicitarIdAutor();

        Autor autor = dao.buscar(id);

        if (autor != null) {
            vista.mostrarAutor(autor);
        } else {
            //mensaje por si no se encuentra el ID
            vista.mostrarMensaje("Autor no encontrado con el ID: " + id);
        }
    }
}