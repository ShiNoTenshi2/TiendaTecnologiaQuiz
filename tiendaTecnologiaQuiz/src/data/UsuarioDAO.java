package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Usuario;


public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }




	public ArrayList<Usuario> fetch() {
		// TODO Auto-generated method stub
		return null;
	}



	public boolean authenticate(String nickname, String contraseña) {
		// TODO Auto-generated method stub
		return false;
	}


}
