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

    public ProductoDAO(Connection connection) {
        this.connection = connection;
    }

	
	public void save(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	
	public ArrayList<Producto> fetch() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void delete(int referencia) {
		// TODO Auto-generated method stub
		
	}

	
	public boolean authenticate(int referencia) {
		// TODO Auto-generated method stub
		return false;
	}


}
