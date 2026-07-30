package org.ar.controller;

import org.ar.dao.imp.CategoriaDAOImpl;
import org.ar.model.Categoria;
import org.ar.view.CategoriaConseleView;
import otg.ar.dao.CategoriDAO;

public class CategoriaController {

    private final CategoriDAO dao;
    private final CategoriaConseleView vista;

    public CategoriaController(CategoriaConseleView vista) {
        this.dao = new CategoriaDAOImpl();
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
        vista.mostrarListaCategorias(dao.listarTodos());
    }

    private void buscar() {
        int id = vista.solicitarID();
        Categoria categoria = dao.buscarPorId(id);
        if (categoria != null) {
            vista.mostrarCategoria(categoria);

        } else {
            vista.mostrarMensaje("Categoria no encontrado con el Id" + id);
        }
    }
}
