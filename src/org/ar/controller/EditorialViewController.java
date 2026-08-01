package org.ar.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import org.ar.dao.imp.editorialDAOImpl;
import org.ar.model.editorial;
import otg.ar.dao.editorialDAO;

public class EditorialViewController implements Initializable {

    @FXML
    private TextField txtNit;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtDireccion;

    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnActualizarTabla;
    @FXML
    private Label lblMensaje;

    @FXML
    private TableView<editorial> tablaEditoriales;
    @FXML
    private TableColumn<editorial, String> colNit;
    @FXML
    private TableColumn<editorial, String> colNombre;
    @FXML
    private TableColumn<editorial, String> colTelefono;
    @FXML
    private TableColumn<editorial, String> colDireccion;

    private editorialDAO dao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dao = new editorialDAOImpl();
        lblMensaje.setText("");

        colNit.setCellValueFactory(new PropertyValueFactory<>("nit"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre_editorial"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono_editorial"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion_editoria"));

        cargarTabla();
    }

    @FXML
    public void eventoGuardar(ActionEvent evento) {

        String nit = txtNit.getText();
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();

        if (nit == null || nit.trim().isEmpty()
                || nombre == null || nombre.trim().isEmpty()) {
            lblMensaje.setText("El NIT y el Nombre son obligatorios.");
            return;
        }

        editorial nueva = new editorial(nit.trim(), nombre.trim(), telefono, direccion);
        boolean guardado = dao.insertar(nueva);

        if (guardado) {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Editorial registrada con éxito");
            eventoLimpiar(null);
            cargarTabla();
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "No se pudo registrar la editorial. Verifique que el NIT no exista ya.");
        }
    }

    @FXML
    public void eventoLimpiar(ActionEvent evento) {
        txtNit.clear();
        txtNombre.clear();
        txtTelefono.clear();
        txtDireccion.clear();
        lblMensaje.setText("");
    }

    @FXML
    public void eventoActualizarTabla(ActionEvent evento) {
        cargarTabla();
    }

    private void cargarTabla() {
        ObservableList<editorial> datos = FXCollections.observableArrayList(dao.listarTodos());
        tablaEditoriales.setItems(datos);
    }

    private void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alerta = new Alert(tipo, mensaje, ButtonType.OK);
        alerta.show();
    }
}
