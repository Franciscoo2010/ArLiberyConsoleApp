package org.ar.controller;

import org.ar.dao.imp.LibroDAOImpl;
import org.ar.model.Libro;
import org.ar.view.LibroConsoleView;
import otg.ar.dao.LibroDAO;

public class LibroController {

    private final LibroDAO dao;
    private final LibroConsoleView vista;

    public LibroController(LibroConsoleView vista) {
        this.dao = new LibroDAOImpl();
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
                case 5:
                    break;
                case 6:
                    break;
                default:
                    throw new AssertionError();
            }

        } while (opcion != 6);
    }

    private void listar() {
        vista.mostrarListaLibros(dao.listarTodos());
    }

    private void buscar() {
        String isbn = vista.solicitarIsbn();
        Libro libro = dao.buscarPorId(isbn);
        if (libro != null) {
            vista.mostrarLibro(libro);

        } else {
            vista.mostrarMensaje("Libro no encontrado con el ISBN" + isbn);
        }
    }
}
