package org.ar.system;
 
import org.ar.view.MenuPrincipal;
 
public class Main {
 
    public static void main(String[] args) {
 
        // MVC Modelo, Vista, Controlador
        // DAO (Objeto de Acceso a Datos)
 
        MenuPrincipal menu = new MenuPrincipal();
        menu.iniciarSistema();
    }
}