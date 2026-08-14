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
 
    @FXML TableView tablaEditoriales;

    @FXML TableColumn colNit;

    @FXML TableColumn colNombre;

    @FXML TableColumn colTelefono;

    @FXML TableColumn colDireccion;
 
    private editorialDAO dao = new editorialDAOImpl();
 
    @Override

    public void initialize(URL url, ResourceBundle rb) {

        configurarTabla();

        cargarTabla();

        seleccionarFila();

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

        tablaEditoriales.getSelectionModel().clearSelection();

        txtNit.setEditable(true);

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
 
    private void configurarTabla() {

        colNit.setCellValueFactory(new PropertyValueFactory<editorial, String>("nit"));

        colNombre.setCellValueFactory(new PropertyValueFactory<editorial, String>("nombre_editorial"));

        colTelefono.setCellValueFactory(new PropertyValueFactory<editorial, String>("telefono_editorial"));

        colDireccion.setCellValueFactory(new PropertyValueFactory<editorial, String>("direccion_editoria"));

    }
 
    private void seleccionarFila() {

        tablaEditoriales.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue != null) {

                editorial item = (editorial) newValue;

                txtNit.setText(item.getNit());

                txtNombre.setText(item.getNombre_editorial());

                txtTelefono.setText(item.getTelefono_editorial());

                txtDireccion.setText(item.getDireccion_editoria());

                txtNit.setEditable(false);

            }

        });

    }
 
}

 