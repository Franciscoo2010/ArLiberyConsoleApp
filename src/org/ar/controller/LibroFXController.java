package org.ar.controller;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
import otg.ar.dao.LibroDAO;
import org.ar.dao.imp.LibroDAOImpl;
import org.ar.model.Libro;
import org.ar.system.Main;

public class LibroFXController implements Initializable {

    @FXML
    private TextField txtIsbn;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtFechaPublicacion;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtIdCategoria;
    @FXML
    private TextField txtNitEditorial;
    @FXML
    private Label lblMensaje;
    @FXML
    private TableView<Libro> tablaLibros;//Tabla de entidad: libro

    @FXML
    TableColumn colIsbn;
    @FXML
    TableColumn colTitulo;
    @FXML
    TableColumn colFechaPublicacion;
    @FXML
    TableColumn colPrecio;
    @FXML
    TableColumn colIdCategoria;
    @FXML
    TableColumn colNitEditorial;

    private LibroDAO dao = new LibroDAOImpl();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarTabla();
        cargarTabla();
        seleccionarFila();
    }

    private void cargarTabla() {
        ObservableList<Libro> listaLibros = FXCollections.observableArrayList(dao.listarTodos());//Entidad:Libro
        tablaLibros.setItems(listaLibros);
    }

    private void seleccionarFila() {
        tablaLibros.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        txtIsbn.setText(String.valueOf(newSelection.getIsbn()));
                        txtTitulo.setText(newSelection.getTitulo());
                        txtFechaPublicacion.setText(newSelection.getFechaPublicacion() != null
                                ? newSelection.getFechaPublicacion().toString() : "");
                        txtPrecio.setText(newSelection.getPrecio() != null
                                ? newSelection.getPrecio().toString() : "");
                        txtIdCategoria.setText(newSelection.getIdCategoria() != null
                                ? String.valueOf(newSelection.getIdCategoria()) : "");
                        txtNitEditorial.setText(newSelection.getNitEditorial());
                    }
                });
    }

    @FXML
    private void handleGuardar() {
        try {
            if (txtIsbn.getText().isEmpty() || txtTitulo.getText().isEmpty()
                    || txtFechaPublicacion.getText().isEmpty() || txtPrecio.getText().isEmpty()
                    || txtIdCategoria.getText().isEmpty() || txtNitEditorial.getText().isEmpty()) {
                mostrarError("Todos los campos son obligatorios.");
                return;
            }

            Libro libro = new Libro();
            libro.setIsbn(txtIsbn.getText().trim());
            libro.setTitulo(txtTitulo.getText().trim());
            libro.setFechaPublicacion(LocalDate.parse(txtFechaPublicacion.getText().trim()));
            libro.setPrecio(new BigDecimal(txtPrecio.getText().trim()));
            libro.setIdCategoria(Integer.parseInt(txtIdCategoria.getText().trim()));
            libro.setNitEditorial(txtNitEditorial.getText().trim());

            if (dao.crear(libro)) {
                lblMensaje.setText("Libro registrado exitosamente.");
                cargarTabla();
                limpiarFormulario();
            } else {
                mostrarError("No se pudo registrar el libro.");
            }
        } catch (DateTimeParseException e) {
            mostrarError("La fecha de publicación debe tener el formato aaaa-mm-dd.");
        } catch (NumberFormatException e) {
            mostrarError("El precio y el id de categoría deben ser numéricos válidos.");
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
            Main.cambiarVista("/org/ar/view/LibroView.fxml");
        } catch (Exception e) {
            mostrarError("Error al volver al menú: " + e.getMessage());
        }
    }

    private void limpiarFormulario() {
        txtIsbn.clear();
        txtTitulo.clear();
        txtFechaPublicacion.clear();
        txtPrecio.clear();
        txtIdCategoria.clear();
        txtNitEditorial.clear();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void configurarTabla() {
        colIsbn.setCellValueFactory(new PropertyValueFactory<Libro, String>("isbn"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<Libro, String>("titulo"));
        colFechaPublicacion.setCellValueFactory(new PropertyValueFactory<Libro, java.time.LocalDate>("fechaPublicacion"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<Libro, BigDecimal>("precio"));
        colIdCategoria.setCellValueFactory(new PropertyValueFactory<Libro, Integer>("idCategoria"));
        colNitEditorial.setCellValueFactory(new PropertyValueFactory<Libro, String>("nitEditorial"));
    }

}
