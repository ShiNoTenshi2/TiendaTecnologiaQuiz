package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Producto;

public class ProductoDAO {
    private Connection connection;

    // Constructor que recibe la conexión a la base de datos
    public ProductoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para guardar un nuevo producto en la base de datos
    public void save(Producto producto) {
        String sql = "INSERT INTO Producto (referencia, nombre, precio, cantidad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Establece los valores de los parámetros en la sentencia SQL
            stmt.setInt(1, producto.getReferencia());  // referencia
            stmt.setString(2, producto.getNombre());    // nombre
            stmt.setDouble(3, producto.getPrecio());    // precio
            stmt.setInt(4, producto.getCantidad());     // cantidad
            stmt.executeUpdate();  // Ejecuta la actualización (insertar en la base de datos)
        } catch (SQLException e) {
            e.printStackTrace();  // Captura y muestra cualquier error de SQL
        }
    }

    // Método para obtener todos los productos de la base de datos
    public ArrayList<Producto> fetch() {
        ArrayList<Producto> productos = new ArrayList<>();  // Lista donde se guardarán los productos recuperados
        String sql = "SELECT * FROM Producto";  // Consulta para obtener todos los productos
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {  // Ejecuta la consulta
            while (rs.next()) {  // Recorre los resultados
                int referencia = rs.getInt("referencia");  // Obtiene la referencia del producto
                String nombre = rs.getString("nombre");    // Obtiene el nombre del producto
                double precio = rs.getDouble("precio");    // Obtiene el precio del producto
                int cantidad = rs.getInt("cantidad");      // Obtiene la cantidad del producto

                // Crea un objeto Producto con los datos obtenidos
                Producto producto = new Producto(referencia, nombre, precio, cantidad);
                productos.add(producto);  // Añade el producto a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Captura y muestra cualquier error de SQL
        }
        return productos;  // Retorna la lista de productos
    }

    // Método para eliminar un producto de la base de datos por referencia
    public void delete(int referencia) {
        String sql = "DELETE FROM Producto WHERE referencia=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, referencia);  // Establece la referencia del producto a eliminar
            stmt.executeUpdate();  // Ejecuta la eliminación en la base de datos
        } catch (SQLException e) {
            e.printStackTrace();  // Captura y muestra cualquier error de SQL
        }
    }

    // Método para autenticar si existe un producto con una determinada referencia
    public boolean authenticate(int referencia) {
        String sql = "SELECT * FROM Producto WHERE referencia=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, referencia);  // Establece la referencia a verificar
            ResultSet rs = stmt.executeQuery();  // Ejecuta la consulta
            if (rs.next()) {
                // Si existe un producto con esa referencia, devuelve true
                return rs.getInt("referencia") == referencia;
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Captura y muestra cualquier error de SQL
        }
        return false;  // Si no existe, devuelve false
    }
}
