package org.ar.system;

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
        Parent raiz = FXMLLoader.load(Main.class.getResource(rutaFXML));            
        Scene escena = new Scene(raiz); 
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.sizeToScene();
        escenarioPrincipal.centerOnScreen();
        escenarioPrincipal.show();        
    }

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        Main.escenarioPrincipal = escenarioPrincipal;
        escenarioPrincipal.setTitle("Key Librería");
        cambiarEscena("/org/ar/view/EditorialView.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}