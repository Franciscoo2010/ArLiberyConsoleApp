package org.ar.system;

import org.ar.view.MenuPrincipal;

public class Main {

    public static void main(String[] args) {
        
        // Patrón de Diseño: MVC (Modelo, Vista, Controlador) y DAO (Objeto de Acceso a Datos).
        // Aplicado correctamente para la gestión de Autores.
        
        MenuPrincipal menu = new MenuPrincipal();
        menu.iniciarSistema();
    }
}
