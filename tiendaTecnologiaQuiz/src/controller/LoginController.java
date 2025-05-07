package controller;

import java.sql.Connection;
import application.Main;
import data.UsuarioDAO;
import data.DBConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private PasswordField txtContraseña; // Campo para la contraseña

    @FXML
    private TextField txtUsuario; // Campo para el nombre de usuario
    
    // Establece la conexión a la base de datos y el DAO de usuario
    private Connection connection = DBConnection.getInstance().getConnection();
    private UsuarioDAO usuarioDAO = new UsuarioDAO(connection);

    // Método para autenticar al usuario al hacer clic en el botón de iniciar sesión
    @FXML
    void iniciarSesion(ActionEvent event) {
        // Verifica si el usuario y la contraseña son correctos
        if(usuarioDAO.authenticate(txtUsuario.getText(), txtContraseña.getText())) {
            // Si son correctos, carga la vista de registro de productos
            Main.loadView("/view/RegistroProductos.fxml");
        } else {
            // Si no, muestra una alerta de usuario inválido
            Main.showAlert("Usuario invalido", "Usuario invalido", "Digite un usuario valido", Alert.AlertType.WARNING);
        }
    }
}
