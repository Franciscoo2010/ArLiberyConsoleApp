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
import otg.ar.dao.ClienteDAO;
import org.ar.dao.imp.ClienteDAOImpl;
import org.ar.model.Clientes;
import org.ar.system.Main;

public class ClienteFXController implements Initializable {

    @FXML
    private TextField txtCui;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCorreo;
    @FXML
    private Label lblMensaje;
    @FXML
    private TableView<Clientes> tablaClientes;//Tabla de entidad: cliente

    @FXML
    TableColumn colCUI;
    @FXML
    TableColumn colNombre;
    @FXML
    TableColumn colApellido;
    @FXML
    TableColumn colCorreo;

    private ClienteDAO dao = new ClienteDAOImpl();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarTabla();
        cargarTabla();
        seleccionarFila();
    }

    private void cargarTabla() {
        ObservableList<Clientes> listaClientes = FXCollections.observableArrayList(dao.listarTodos());//Entidad:Cliente
        tablaClientes.setItems(listaClientes);
    }

    private void seleccionarFila() {
        tablaClientes.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        txtCui.setText(String.valueOf(newSelection.getCui()));
                        txtNombre.setText(newSelection.getNombre());
                        txtApellido.setText(newSelection.getApellido());
                        txtCorreo.setText(newSelection.getCorreoElectronico());
                    }
                });
    }

    @FXML
    private void handleGuardar() {
        try {
            if (txtCui.getText().isEmpty() || txtNombre.getText().isEmpty()
                    || txtApellido.getText().isEmpty() || txtCorreo.getText().isEmpty()) {
                mostrarError("Todos los campos son obligatorios.");
                return;
            }

            Clientes cliente = new Clientes();
            cliente.setCui(Long.parseLong(txtCui.getText().trim()));
            cliente.setNombre(txtNombre.getText().trim());
            cliente.setApellido(txtApellido.getText().trim());
            cliente.setCorreoElectronico(txtCorreo.getText().trim());

            if (dao.crear(cliente)) {
                lblMensaje.setText("Cliente registrado exitosamente.");
                cargarTabla();
                limpiarFormulario();
            } else {
                mostrarError("No se pudo registrar el cliente.");
            }
        } catch (NumberFormatException e) {
            mostrarError("El CUI debe ser un número válido.");
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
            Main.cambiarVista("/org/ar/view/ClienteView.fxml");
        } catch (Exception e) {
            mostrarError("Error al volver al menú: " + e.getMessage());
        }
    }

    private void limpiarFormulario() {
        txtCui.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtCorreo.clear();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void configurarTabla() {
        colCUI.setCellValueFactory(new PropertyValueFactory<Clientes, Long>("cui"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Clientes, String>("Nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<Clientes, String>("Apellido"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<Clientes, String>("correoElectronico"));
    }

}
