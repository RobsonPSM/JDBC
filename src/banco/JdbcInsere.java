package banco;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;

public class JdbcInsere {
	public static void main(String[] args) {
		Connection con;
		PreparedStatement stmt;
		try {
			String sqlinsert = "INSERT INTO CONTATOS (nome, email, endereco) values (?, ?, ?)";
			con = FabricaDeConexoes.getConnection();
			stmt = con.prepareStatement(sqlinsert);
			stmt.setString(1, "Robson");
			stmt.setString(2, "robson@gmail.com");
			stmt.setString(3, "Fundão ilha do governador");
			int totalRegistrosAfetados = stmt.executeUpdate();
			if(totalRegistrosAfetados == 0) {
				System.out.println("Não foi feito o cadastro!!");
			}else {
				System.out.println("Cadastro realizado!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
