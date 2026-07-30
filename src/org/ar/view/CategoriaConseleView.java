package org.ar.view;
 
import java.util.Scanner;
import java.util.List;
import org.ar.model.Categoria;
 
public class CategoriaConseleView {
 
    private final Scanner leer = new Scanner(System.in);
 
    //metodo para mostrar las opciones de este menú
    public int mostrarMenu() {
        int opcion;
 
        System.out.println("-------Gestion de Categorias---------");
        System.out.println("-1 CREAR NUEVA CATEGORIA-");
        System.out.println("-2 LISTAR CATEGORIAS-");
        System.out.println("-3 BUSCAR CATEGORIA POR ID-");
        System.out.println("-4 MODIFICAR CATEGORIA-");
        System.out.println("-5 ELIMINAR CATEGORIA-");
        System.out.println("-6 REGRESAR MENU PRINCIPAL-");
        System.out.println("-Seleccione una opción-");
        opcion = Integer.parseInt(leer.nextLine());
        return opcion;
    }
 
    public int solicitarID() {
    System.out.println("Ingrese el ID de la categoria");
    return Integer.parseInt(leer.nextLine());
}
 
    public String solicitarNombreCategoria() {
        System.out.println("Ingrese el nombre de la categoria");
        String nombre;
        nombre = leer.nextLine();
        return nombre;
    }
 
    //mostrar el detalle de una CATEGORIA
    public void mostrarCategoria(Categoria categoria) {
        System.out.println("--- DATOS DE LA CATEGORIA ---");
        System.out.println("ID: " + categoria.getId());
        System.out.println("NOMBRE: " + categoria.getNombre());
    }
 
    //mostrar la lista de CATEGORIAS
    public void mostrarListaCategorias(List<Categoria> categorias) {
        System.out.println("--LISTA DE CATEGORIAS ---");

        System.out.printf("%-10s %-20s%n",
                "ID", "NOMBRE");
 
        for (Categoria categoria : categorias) {
            System.out.printf("%-10s %-20s%n",
                    categoria.getId(),
                    categoria.getNombre());
        }
    }
 
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
 
}