package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTeste2 {
	public static void main(String[] args) {
		Connection con;
		
		try {
			con = FabricaDeConexoes.getConnection();
			con.close();
			System.out.println("Conectado ao DB!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
