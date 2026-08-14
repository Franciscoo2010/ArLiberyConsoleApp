package org.ar.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import otg.ar.dao.AutorDAO;
import org.ar.dao.imp.AutorDAOImpl;
import org.ar.model.Autor;
import org.ar.system.Main;

public class AutorFXController implements Initializable {

    @FXML
    private TextField txtIdAutor;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtNacionalidad;
    @FXML
    private TextField txtBiografia;
    @FXML
    private Label lblMensaje;
    @FXML
    private TableView<Autor> tablaAutores; // Tabla de entidad: autor
    //colID, colNombre, colApellido, colNacionalidad, colBiografia
    @FXML    TableColumn colId;
    @FXML    TableColumn colNombre;
    @FXML    TableColumn colApellido;
    @FXML    TableColumn colNacionalidad;
    @FXML    TableColumn colBiografia;

    private final AutorDAO autorDAO = new AutorDAOImpl();
    private final ObservableList<Autor> listaAutores = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configurarTabla();
        cargarTabla();
        seleccionarFila();
    }

    private void cargarTabla() {
        listaAutores.setAll(autorDAO.listarTodos());
        tablaAutores.setItems(listaAutores);
    }

    private void seleccionarFila() {
        tablaAutores.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        txtIdAutor.setText(String.valueOf(newSelection.getIdAutor()));
                        txtNombre.setText(newSelection.getNombre());
                        txtApellido.setText(newSelection.getApellido());
                        txtNacionalidad.setText(newSelection.getNacionalidad());
                    }
                });
    }

    @FXML
    private void handleGuardar() {
        try {
            if (txtIdAutor.getText().isEmpty() || txtNombre.getText().isEmpty()
                    || txtApellido.getText().isEmpty() || txtNacionalidad.getText().isEmpty()) {
                mostrarError("Todos los campos son obligatorios.");
                return;
            }

            Autor autor = new Autor();
            autor.setIdAutor(Integer.parseInt(txtIdAutor.getText().trim()));
            autor.setNombre(txtNombre.getText().trim());
            autor.setApellido(txtApellido.getText().trim());
            autor.setNacionalidad(txtNacionalidad.getText().trim());
            autor.setBiografia(txtBiografia.getText().trim());

            if (autorDAO.crear(autor)) {
                lblMensaje.setText("Autor registrado exitosamente.");
                cargarTabla();
                limpiarFormulario();
            } else {
                mostrarError("No se pudo registrar el autor.");
            }
        } catch (NumberFormatException e) {
            mostrarError("El ID del autor debe ser un número válido.");
        } catch (Exception e) {
            mostrarError("Error al guardar: " + e.getMessage());
        }
    }

    @FXML
    private void handleLimpiar() {
        limpiarFormulario();
        lblMensaje.setText("");
    }

    @FXML
    private void handleActualizar() {
        cargarTabla();
        lblMensaje.setText("Tabla actualizada.");
    }

    @FXML
    private void handleVolver() {
        try {
            Main.cambiarEscena("/org/ar/view/InisioSesionView.fxml");
        } catch (Exception e) {
            mostrarError("Error al volver al menú: " + e.getMessage());
        }
    }

    private void limpiarFormulario() {
        txtIdAutor.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtNacionalidad.clear();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void configurarTabla() {
        //CallValueFactory, propertValueFactory
        //Valor de fabrica de celdam propiedad de fabrica de celda
        colId.setCellValueFactory(new PropertyValueFactory<Autor, Integer>("idAutor"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Autor, String>("nombreAutor"));
        colApellido.setCellValueFactory(new PropertyValueFactory<Autor, String>("apellidoAutor"));
        colNacionalidad.setCellValueFactory(new PropertyValueFactory<Autor, String>("nacionalidad"));
        colBiografia.setCellValueFactory(new PropertyValueFactory<Autor, String>("biografia"));

    }
}

