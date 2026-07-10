package org.ar.view;

import java.util.List;
import java.util.Scanner;
import org.ar.model.Autor;


public class AutorConsoleView {

    private final Scanner leer = new Scanner(System.in);

    public int mostrarMenu() {

        int opcion;

        System.out.println("------ GESTION DE AUTORES ------");
        System.out.println("1. CREAR AUTOR");
        System.out.println("2. LISTAR AUTORES");
        System.out.println("3. BUSCAR AUTOR");
        System.out.println("4. MODIFICAR AUTOR");
        System.out.println("5. ELIMINAR AUTOR");
        System.out.println("6. REGRESAR");
        System.out.print("Seleccione una opción: ");

        opcion = Integer.parseInt(leer.nextLine());

        return opcion;
    }

    public int solicitarId() {
        System.out.print("Ingrese el ID del autor: ");
        return Integer.parseInt(leer.nextLine());
    }

public void mostrarListaAutores(List<Autor> autores) {

    System.out.printf(
            "%-5s %-20s %-20s %-20s %-30s%n",
            "ID", "NOMBRE", "APELLIDO", "NACIONALIDAD", "BIOGRAFIA");

    for (Autor autor : autores) {
        System.out.printf(
                "%-5d %-20s %-20s %-20s %-30s%n",
                autor.getId_autor(),
                autor.getNombre_autor(),
                autor.getApellido_autor(),
                autor.getNacionalidad(),
                autor.getBiografia());
    }
}

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
