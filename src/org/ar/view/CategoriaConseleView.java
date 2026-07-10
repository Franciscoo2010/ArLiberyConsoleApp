package org.ar.view;

import java.util.Scanner;
import java.util.List;
import org.ar.model.Categoria;

public class CategoriaConseleView {

    private final Scanner leer = new Scanner(System.in);

    // Mostrar menú
    public int mostrarMenu() {

        System.out.println("------- Gestion de Clientes ---------");
        System.out.println("1. CREAR NUEVO CLIENTE");
        System.out.println("2. LISTAR CLIENTES");
        System.out.println("3. BUSCAR CLIENTE POR ID");
        System.out.println("4. MODIFICAR CLIENTE");
        System.out.println("5. ELIMINAR CLIENTE");
        System.out.println("6. REGRESAR MENU PRINCIPAL");
        System.out.println("Seleccione una opción:");

        return Integer.parseInt(leer.nextLine());
    }


    public long solicitarCUI() {

        System.out.println("Ingrese el CUI del cliente:");
        return Long.parseLong(leer.nextLine());

    }


    public String solicitarNombreCliente() {

        System.out.println("Ingrese el nombre del cliente:");
        return leer.nextLine();

    }


    public String solicitarApellidoCliente() {

        System.out.println("Ingrese el apellido del cliente:");
        return leer.nextLine();

    }


    public String solicitarCorreoElectronico() {

        System.out.println("Ingrese el correo electrónico:");
        return leer.nextLine();

    }


    // Mostrar un cliente/categoria
    public void mostrarCliente(Categoria categoria) {

        System.out.println("--- DATOS DEL CLIENTE ---");
        System.out.println("CUI: " + categoria.getCui());
        System.out.println("NOMBRE: " + categoria.getNombre());
        System.out.println("APELLIDO: " + categoria.getApellido());
        System.out.println("CORREO: " + categoria.getCorreoElectronico());

    }


    // Mostrar lista
    public void mostrarlistaCategoria(List<Categoria> categorias) {

        System.out.println("--- LISTA DE CLIENTES ---");

        if (categorias.isEmpty()) {
            System.out.println("No hay registros.");
            return;
        }


        for (Categoria categoria : categorias) {

            System.out.println("-------------------------");
            System.out.println("CUI: " + categoria.getCui());
            System.out.println("NOMBRE: " + categoria.getNombre());
            System.out.println("APELLIDO: " + categoria.getApellido());
            System.out.println("CORREO: " + categoria.getCorreoElectronico());

        }

    }


    // Solicitar ID para buscar
    public int solicitarIdCategoria() {

        System.out.println("Ingrese el ID de la categoria:");
        return Integer.parseInt(leer.nextLine());

    }


    // Mostrar categoria encontrada
    public void mostrarCategoria(Categoria categoria) {

        System.out.println("--- DATOS DE LA CATEGORIA ---");
        System.out.println("CUI: " + categoria.getCui());
        System.out.println("NOMBRE: " + categoria.getNombre());
        System.out.println("APELLIDO: " + categoria.getApellido());
        System.out.println("CORREO: " + categoria.getCorreoElectronico());

    }


    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);

    }

}