package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO {
    private Connection connection;

    // Constructor que recibe la conexión a la base de datos
    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para autenticar un usuario con su nickname y contraseña
    public boolean authenticate(String nickname, String contraseña) {
        String sql = "SELECT * FROM Usuario WHERE nickname=? AND contraseña=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Establece los valores de los parámetros en la sentencia SQL
            stmt.setString(1, nickname);  // nickname del usuario
            stmt.setString(2, contraseña);  // contraseña del usuario
            ResultSet rs = stmt.executeQuery();  // Ejecuta la consulta
            if (rs.next()) {
                // Si hay resultados, compara el nickname y la contraseña
                return rs.getString("nickname").equals(nickname) && rs.getString("contraseña").equals(contraseña);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Captura y muestra cualquier error de SQL
        }
        return false;  // Si no se encontró el usuario o la contraseña es incorrecta, retorna false
    }
}
