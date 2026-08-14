package org.ar.system;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Permite abrir el panel JavaFX "Key Librería" (Registrar / Listar
 * Categorías) desde el menú de consola (MenuPrincipal) sin alterar la
 * estructura del proyecto ni el flujo del Main.java existente.
 */
public class CategoriaFXLauncher {

    private static boolean toolkitIniciado = false;

    public static void mostrar() {

        CountDownLatch cerrado = new CountDownLatch(1);
        Runnable tarea = () -> abrirVentana(cerrado);

        if (!toolkitIniciado) {
            toolkitIniciado = true;
            Platform.startup(tarea);
        } else {
            Platform.runLater(tarea);
        }

        try {
            cerrado.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void abrirVentana(CountDownLatch cerrado) {
        try {
            Parent raiz = FXMLLoader.load(CategoriaFXLauncher.class.getResource("/org/ar/view/CategoriaView.fxml"));
            Stage escenario = new Stage();
            escenario.setTitle("Key Librería");
            escenario.setScene(new Scene(raiz));
            escenario.setOnHidden(e -> cerrado.countDown());
            escenario.show();
        } catch (IOException e) {
            System.err.println("Error al abrir el panel de categorías: " + e.getMessage());
            cerrado.countDown();
        }
    }
}
