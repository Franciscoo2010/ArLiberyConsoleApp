package org.ar.view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;
import org.ar.model.Libro;

public class LibroConsoleView {

    private final Scanner leer = new Scanner(System.in);

    //metodo para mostrar las opciones de este menú
    public int mostrarMenu() {
        int opcion;

        System.out.println("-------Gestion de Libros---------");
        System.out.println("-1 CREAR NUEVO LIBRO-");
        System.out.println("-2 LISTAR LIBROS-");
        System.out.println("-3 BUSCAR LIBRO POR ISBN-");
        System.out.println("-4 MODIFICAR LIBRO-");
        System.out.println("-5 ELIMINAR LIBRO-");
        System.out.println("-6 REGRESAR MENU PRINCIPAL-");
        System.out.println("-Seleccione una opción-");
        opcion = Integer.parseInt(leer.nextLine());
        return opcion;
    }

    public String solicitarIsbn() {
        System.out.println("ingrese el ISBN del libro");
        return leer.nextLine();
    }

    public String solicitarTitulo() {
        System.out.println("ingrese el Titulo del libro");
        String titulo;
        titulo = leer.nextLine();
        return titulo;
        //otra forma de hacerlo
    }

    public LocalDate solicitarFechaPublicacion() {
        System.out.println("ingrese la Fecha de publicación (aaaa-mm-dd)");
        return LocalDate.parse(leer.nextLine());
    }

    public BigDecimal solicitarPrecio() {
        System.out.println("ingrese el Precio del libro");
        return new BigDecimal(leer.nextLine());
    }

    public Integer solicitarIdCategoria() {
        System.out.println("ingrese el Id de la categoria");
        return Integer.parseInt(leer.nextLine());
    }

    public String solicitarNitEditorial() {
        System.out.println("ingrese el Nit de la editorial");
        return leer.nextLine();
    }

    //mostrar el detalle de un LIBRO
    public void mostrarLibro(Libro libro) {
        System.out.println("--- DATOS DEL LIBRO ---");
        System.out.println("ISBN: " + libro.getIsbn());
        System.out.println("TITULO: " + libro.getTitulo());
        System.out.println("FECHA DE PUBLICACION: " + libro.getFechaPublicacion());
        System.out.println("PRECIO: " + libro.getPrecio());
        System.out.println("ID CATEGORIA: " + libro.getIdCategoria());
        System.out.println("NIT EDITORIAL: " + libro.getNitEditorial());
    }

    //mostrar la lista de LIBROS -- lista de objeto List<T>, ArrayList<Libro>
    public void mostrarListaLibros(List<Libro> libros) {
        System.out.println("--LISTA DE LIBROS ---");
        //tabla usando la propidad %- tamaño de columtas
        System.out.printf("%-15s %-30s %-15s %-10s %-10s %-15s%n",
                "ISBN", "TITULO", "FECHA PUB.", "PRECIO", "ID CAT.", "NIT EDIT.");

        for (Libro libro : libros) {
            System.out.printf("%-15s %-30s %-15s %-10s %-10s %-15s%n",
                    libro.getIsbn(),
                    libro.getTitulo(),
                    libro.getFechaPublicacion(),
                    libro.getPrecio(),
                    libro.getIdCategoria(),
                    libro.getNitEditorial());

        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}
