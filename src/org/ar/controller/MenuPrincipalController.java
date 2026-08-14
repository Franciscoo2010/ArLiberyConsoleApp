package org.ar.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import org.ar.system.Main;

public class MenuPrincipalController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Código de inicialización de la vista si fuera necesario
    }

    /**
     * Método centralizado para cambiar de escena usando un switch-case.
     * Unifica la gestión de errores en un solo try-catch.
     */
    public void navegar(String modulo) {
        String rutaFxml = "";

        switch (modulo) {
            case "Clientes":
                rutaFxml = "/org/ar/view/ClienteView.fxml";
                break;
            case "Categorias":
                rutaFxml = "/org/ar/view/CategoriaView.fxml";
                break;
            case "Editorial":
                rutaFxml = "/org/ar/view/EditorialView.fxml";
                break;
            case "Autores":
                rutaFxml = "/org/ar/view/AutorView.fxml";
                break;
            default:
                mostrarError("Módulo no reconocido: " + modulo);
                return;
        }

        try {
            Main.cambiarEscena(rutaFxml);
        } catch (Exception e) {
            mostrarError("Error al cargar el módulo de " + modulo.toLowerCase() + ":\n" + e.getMessage());
        }
    }

    // --- Manejadores de Eventos FXML ---

    @FXML
    private void handleClientes() {
        navegar("Clientes");
    }

    @FXML
    private void handleCategorias() {
        navegar("Categorias");
    }

    @FXML
    private void handleEditorial() {
        navegar("Editorial");
    }

    @FXML
    private void handleAutores() {
        navegar("Autores");
    }

    @FXML
    private void handleNoDisponible() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Módulo no disponible");
        alert.setHeaderText(null);
        alert.setContentText("Este módulo no está disponible aún.");
        alert.showAndWait();
    }

    @FXML
    private void handleSalir() {
        Platform.exit();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
