package org.ar.view;

import java.util.Scanner;
import org.ar.controller.AutorController;
import org.ar.controller.AutorController; // Corregido a singular
import org.ar.view.AutorConsoleView;
import org.ar.view.AutorConsoleView; // Corregido a singular

public class MenuPrincipal {

    private final Scanner leer = new Scanner(System.in);

    // Herramienta scanner: lee datos del usuario
    public void iniciarSistema() {
        int opcion;

        // Ciclo para el menú: do while
        do {            
            System.out.println("--------------------------------------");
            System.out.println("    SISTEMA CENTRAL LIBRERIA - IN4CM");
            System.out.println("--------------------------------------");
            System.out.println("1. Entrar a CLIENTES");
            System.out.println("2. Entrada a CATEGORIAS");
            System.out.println("3. Entrada a LIBROS");
            System.out.println("4. Entrada a EDITORIALES");
            System.out.println("5. Entrada a COMPRAS");
            System.out.println("6. Entrada a AUTORES");
            System.out.println("7. Entrada a DETALLE AUTORES");
            System.out.println("8. SALIR DEL SISTEMA");
            System.out.println("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(leer.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0; // Evita que el programa truene si ingresan letras
            }

            // switch / case
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    System.out.println("CATEGORIAS");
                    break;
                case 3:
                    System.out.println("LIBROS");
                    break;
                case 4:
                    System.out.println("EDITORIALES");
                    break;
                case 5:
                    System.out.println("COMPRAS");
                    break;
                case 6:
                    // Instanciar el flujo de Autor en singular
                    AutorConsoleView vistaAutor = new AutorConsoleView();
                    AutorController controlAutor = new AutorController(vistaAutor);
                    controlAutor.iniciar();
                    break;
                case 7:
                    System.out.println("DETALLE AUTORES");
                    break;
                case 8:
                    System.out.println("\n Hasta luego sixseveniano...");
                    break;
                default:
                    System.out.println("No existe esta opción");
            }
        } while (opcion != 8);
    }
}