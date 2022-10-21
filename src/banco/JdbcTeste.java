package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTeste {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/";
		String user = "root";
		String password = "root";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado ao DB!");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
