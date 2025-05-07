package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
    private static BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        try {
            // Carga el archivo FXML para la pantalla de login
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login.fxml"));
            rootLayout = loader.load();
            
            // Crea la escena y le aplica una hoja de estilos
            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
            
            // Asigna la escena al stage principal
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace(); // Captura errores durante la carga
        }
    }

    // Método main que inicia la aplicación
    public static void main(String[] args) {
        launch(args);
    }

    // Método para cambiar el contenido de la vista cargando una nueva vista FXML
    public static void loadView(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlFile));
            rootLayout.setCenter(loader.load());
        } catch (Exception e) {
            e.printStackTrace(); // Captura errores durante la carga de la nueva vista
        }
    }

    // Método para mostrar alertas personalizadas
    public static void showAlert(String title, String header, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
