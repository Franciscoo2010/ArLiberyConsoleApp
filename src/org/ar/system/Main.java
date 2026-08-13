package org.ar.system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {

    private static Stage escenarioPrincipal;

    public static void cambiarEscena(String rutaFXML) throws Exception {
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

        // Abre directamente Categorías
        cambiarEscena("/org/ar/view/CategoriaView.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
