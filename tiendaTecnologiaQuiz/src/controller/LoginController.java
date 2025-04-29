package controller;

import java.sql.Connection;

import application.Main;
import data.UsuarioDAO;
import data.DBConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private PasswordField txtContraseña;

    @FXML
    private TextField txtUsuario;
    
    //private Connection connection = DBConnection.getInstance().getConnection();
    //private UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
    

    @FXML
    void iniciarSesion(ActionEvent event) {
    	 Main.loadView("/view/RegistroProductos.fxml");

    }

}

