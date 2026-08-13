package org.ar.view;

import java.util.Scanner; 
import org.ar.controller.AutorController;
//menú principal de principio
public class MenuPrincipal {
Scanner leer = new Scanner(System.in);
    public void iniciar(){
        int opcion = 0;
        do {
            System.out.println("SELECCIONA UNA OPCIÓN");
            System.out.println("1. Cliente");
            System.out.println("2. Autores");
            System.out.println("3. Categorias");
            System.out.println("5. Editoriales");
            System.out.println("4. Salir");
            opcion = Integer.parseInt(leer.nextLine());
            switch (opcion) {
                case 1:
                    System.out.println("Cliente");
                    break;
                case 2:
                    System.out.println("Autor");
                    AutorConsoleView vistaAutor = new AutorConsoleView();
                    AutorController controladorAutor= new AutorController (vistaAutor);
                    controladorAutor.iniciar();
                    break;
                case 3:
                    System.out.println("Categoria");
                    break;
                case 4:
                    System.out.println("Adiós Vaquero!");
                    break;   
                case 5:
                    System.out.println("Editoriales");
                    break;
                default:
                    System.out.println("NO existe esta opción");
            }
        } while (opcion != 4);
    }
}
