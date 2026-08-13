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
import javafx.stage.Stage;
import org.ar.dao.imp.CategoriaDAOImpl;
import org.ar.model.Categoria;
import otg.ar.dao.CategoriDAO;

public class CategoriaViewController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnVolver;
    @FXML
    private Label lblMensaje;

    @FXML
    TableView tblCategorias;
    @FXML
    TableColumn colId;
    @FXML
    TableColumn colNombre;

    private final CategoriDAO dao;

    public CategoriaViewController() {
        this.dao = new CategoriaDAOImpl();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarTabla();
        cargarTabla();
    }

    @FXML
    public void guardarCategoria(ActionEvent evento) {

        String nombre = txtNombre.getText();

        if (nombre == null || nombre.trim().isEmpty()) {
            lblMensaje.setText("El nombre de la categoría es obligatorio");
            return;
        }

        Categoria categoria = new Categoria();
        categoria.setNombre(nombre.trim());

        boolean guardado = dao.insertar(categoria);

        if (guardado) {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Categoría registrada correctamente");
            limpiarCampos(null);
            cargarTabla();
        } else {
            lblMensaje.setText("No se pudo registrar la categoría");
        }
    }

    @FXML
    public void limpiarCampos(ActionEvent evento) {
        txtNombre.clear();
        lblMensaje.setText("");
    }

    @FXML
    public void actualizarTabla(ActionEvent evento) {
        cargarTabla();
    }

    @FXML
    public void volverMenu(ActionEvent evento) {
        Stage escenario = (Stage) btnVolver.getScene().getWindow();
        escenario.close();
    }

    private void cargarTabla() {
        ObservableList<Categoria> categorias = FXCollections.observableArrayList(dao.listarTodos());
        tblCategorias.setItems(categorias);
    }

    private void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alerta = new Alert(tipo, mensaje, ButtonType.OK);
        alerta.show();
    }

    private void configurarTabla() {
        colId.setCellValueFactory(new PropertyValueFactory<Categoria, String >("Id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Categoria, String >("nombre"));
        
    }

}
