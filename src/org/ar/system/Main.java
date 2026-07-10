package org.ar.system;
 
import org.ar.view.MenuPrincipal;
 
public class Main {
    public static void main(String[] args) {
        //sout
        //MVC Modelo,Vista, Controlador. Esto mejora la legibilidad y estandariza en código (patron de diseño)
        //DAO (objeto de acceso a datos)
        MenuPrincipal menu = new MenuPrincipal();
        menu.iniciarSistema();
    }
    
}
