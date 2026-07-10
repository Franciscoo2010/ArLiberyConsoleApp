package org.ar.controller;

import otg.ar.dao.editorialDAO;
import org.ar.dao.imp.editorialDAOImpl;
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

            if (opcion == 2) {
                listar();
            }

        } while (opcion != 6);
    }

    private void listar() {
        vista.mostrarListaEditoriales(dao.listarTodos());
    }
}