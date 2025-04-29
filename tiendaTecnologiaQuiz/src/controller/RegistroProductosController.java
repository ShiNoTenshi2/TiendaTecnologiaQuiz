package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class RegistroProductosController {

    @FXML
    private TableColumn<?, ?> columnCantidad;

    @FXML
    private TableColumn<?, ?> columnNombre;

    @FXML
    private TableColumn<?, ?> columnPrecio;

    @FXML
    private TableView<?> tableProductos;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtReferencia;

    @FXML
    void eliminar(ActionEvent event) {

    }

    @FXML
    void registrar(ActionEvent event) {

    }
    
    @FXML
    void cerrarSesion(ActionEvent event) {

    }

}

