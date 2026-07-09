package org.ar.system;

import java.util.List;
import org.ar.dao.imp.editorialDAOImpl;
import org.ar.model.editorial;

public class Main {

    public static void main(String[] args) {

        editorialDAOImpl dao = new editorialDAOImpl();

        List<editorial> lista = dao.listarTodos();

        if (lista.isEmpty()) {
            System.out.println("No hay editoriales registradas.");
        } else {
            for (editorial e : lista) {
                System.out.println("NIT: " + e.getNit());
                System.out.println("Nombre: " + e.getNombre_editorial());
                System.out.println("Teléfono: " + e.getTelefono_editorial());
                System.out.println("Dirección: " + e.getDireccion_editoria());
                System.out.println("-------------------------");
            }
        }
    }
}