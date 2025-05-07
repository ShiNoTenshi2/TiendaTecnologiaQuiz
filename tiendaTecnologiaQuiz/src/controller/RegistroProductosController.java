package controller;

import java.sql.Connection;
import application.Main;
import data.DBConnection;
import data.ProductoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Producto;

public class RegistroProductosController {

    @FXML
    private TableColumn<Producto, Integer> columnCantidad; // Columna para la cantidad del producto

    @FXML
    private TableColumn<Producto, String> columnNombre; // Columna para el nombre del producto

    @FXML
    private TableColumn<Producto, Double> columnPrecio; // Columna para el precio del producto

    @FXML
    private TableView<Producto> tableProductos; // Tabla que muestra los productos

    @FXML
    private TextField txtCantidad; // Campo de texto para la cantidad del producto

    @FXML
    private TextField txtNombre; // Campo de texto para el nombre del producto

    @FXML
    private TextField txtPrecio; // Campo de texto para el precio del producto

    @FXML
    private TextField txtReferencia; // Campo de texto para la referencia del producto
    
    // Conexión a la base de datos y DAO de productos
    private Connection connection = DBConnection.getInstance().getConnection();
    private ProductoDAO productoDAO = new ProductoDAO(connection);
    
    // Método de inicialización que carga los productos en la tabla
    @FXML
    public void initialize() {
        ObservableList<Producto> availableProductos = FXCollections.observableArrayList();
        
        // Recupera todos los productos desde la base de datos y los agrega a la lista
        for (Producto producto: productoDAO.fetch()) {
            availableProductos.add(producto); // Añade cada producto a la lista
        }

        // Vincula las columnas de la tabla con los atributos de los productos
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        columnCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        // Asigna los datos a la TableView
        tableProductos.setItems(availableProductos);
    }

    // Método para eliminar un producto seleccionado de la tabla
    @FXML
    void eliminar(ActionEvent event) {
        if (!tableProductos.getSelectionModel().isEmpty()) {
            Producto producto = tableProductos.getSelectionModel().getSelectedItem();
            productoDAO.delete(producto.getReferencia()); // Elimina el producto de la base de datos
            initialize(); // Vuelve a cargar los productos en la tabla
        } else {
            // Muestra una alerta si no se seleccionó ningún producto
            Main.showAlert("Seleccione un registro", "Seleccione un registro", "Debe seleccionar un dato de la tabla", Alert.AlertType.WARNING);
        }
    }

    // Método para registrar un nuevo producto
    @FXML
    void registrar(ActionEvent event) {
        int referencia = Integer.parseInt(txtReferencia.getText()); // Obtiene la referencia del producto
        double precio = Double.parseDouble(txtPrecio.getText()); // Obtiene el precio del producto
        String nombre = txtNombre.getText(); // Obtiene el nombre del producto
        int cantidad = Integer.parseInt(txtCantidad.getText()); // Obtiene la cantidad del producto

        // Verifica si la referencia ya existe en la base de datos
        if (!productoDAO.authenticate(referencia)) {
            // Si no existe, guarda el nuevo producto
            Producto producto = new Producto(referencia, nombre, precio, cantidad);
            productoDAO.save(producto);
            initialize(); // Vuelve a cargar los productos en la tabla
        } else {
            // Si la referencia ya existe, muestra una alerta
            Main.showAlert("Referencia repetida", "Referencia repetida", "Debe registrar una referencia diferente", Alert.AlertType.WARNING);
        }
    }
    
    // Método para cerrar sesión y volver a la pantalla de login
    @FXML
    void cerrarSesion(ActionEvent event) {
        Main.loadView("/view/Login.fxml"); // Carga la vista de login
    }
}
