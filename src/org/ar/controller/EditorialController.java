package org.ar.controller;

import otg.ar.dao.editorialDAO;
import org.ar.dao.imp.editorialDAOImpl;
import org.ar.model.editorial;
import org.ar.view.EditorialConsoleView;

public class EditorialController {

    private final editorialDAO dao;
    private final EditorialConsoleView vista;

    public EditorialController(EditorialConsoleView vista) {
        this.dao = new editorialDAOImpl();
        this.vista = vista;
    }

    public void iniciar() {

        int opcion;

        do {

            opcion = vista.mostrarMenu();

            switch (opcion) {

                case 1:
                    vista.mostrarMensaje("Opción aún no implementada.");
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    buscar();
                    break;

                case 4:
                    vista.mostrarMensaje("Opción aún no implementada.");
                    break;

                case 5:
                    vista.mostrarMensaje("Opción aún no implementada.");
                    break;

                case 6:
                    vista.mostrarMensaje("Regresando al menú principal...");
                    break;

                default:
                    vista.mostrarMensaje("Opción inválida.");
                    break;
            }

        } while (opcion != 6);
    }

    private void listar() {
        vista.mostrarListaEditoriales(dao.listarTodos());
    }

    private void buscar() {

        String nit = vista.solicitarNit();

        editorial edi = dao.buscar(nit);

        if (edi != null) {
            vista.mostrarEditorial(edi);
        } else {
            vista.mostrarMensaje("No existe una editorial con ese NIT.");
        }
    }
}