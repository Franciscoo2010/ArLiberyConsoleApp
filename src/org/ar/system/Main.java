package org.ar.system;
 
import org.ar.view.MenuPrincipal;
 
public class Main {
 
    public static void main(String[] args) {
 
        // MVC Modelo, Vista, Controlador
        // DAO (Objeto de Acceso a Datos)
 
        MenuPrincipal menu = new MenuPrincipal();
        menu.iniciarSistema();

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
 
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Alvaro Calderon
 */
public class Main extends Application {

    private static Stage escenarioPrincipal;

    public static void cambiarEscena(String rutaFXML) throws IOException {
        //Parent raiz = FXMLLoader.load(getClass().getResource(rutaFXML));
        Parent raiz = FXMLLoader.load(Main.class.getResource(rutaFXML));
        Scene escena = new Scene(raiz);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.sizeToScene();
        escenarioPrincipal.centerOnScreen();
        escenarioPrincipal.show();
    }

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        //convertir .fxml en nodo raiz
        Main.escenarioPrincipal = escenarioPrincipal;
        escenarioPrincipal.setTitle("Key Librería");
        //Se arranca directo en la vista de Editorial, sin pedir login.
        //El login (InicioSesionView) se deja disponible en el proyecto
        //por si se necesita reactivar mas adelante.
        cambiarEscena("/org/ar/view/EditorialView.fxml");
    }

 
public class Main extends Application {
 
    private static Stage escenarioPrincipal;
 
    public static void cambiarEscena(String rutaFXML) throws IOException {
        //Parent raiz = FXMLLoader.load(getClass().getResource(rutaFXML));
        Parent raiz = FXMLLoader.load(Main.class.getResource(rutaFXML));                
        Scene escena = new Scene(raiz); 
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.sizeToScene();
        escenarioPrincipal.centerOnScreen();
        escenarioPrincipal.show();        
    }
 
    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        //convertir .fxml en nodo raiz
        Main.escenarioPrincipal = escenarioPrincipal;     
        cambiarEscena("/org/ar/view/InisioSesionView.fxml");
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}