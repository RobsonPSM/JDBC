package dao;

import modelo.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banco.FabricaDeConexoes;

public class ContatoDao {
	private Connection con;
	PreparedStatement stmt;
	
	public ContatoDao() throws SQLException {
		this.con = FabricaDeConexoes.getConnection();
	}
	
	
	public void adiciona(Contato contato) throws SQLException {
		String sqlinsert = "INSERT INTO contatos (nome, email, endereco) values (?, ?, ?)";
		stmt = con.prepareStatement(sqlinsert);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.execute();
		stmt.close();
	}
	
	public List<Contato> getLista() throws SQLException{
		String sql_select = "SELECT * FROM contatos";
		PreparedStatement stmt = con.prepareStatement(sql_select);
		ResultSet result = stmt.executeQuery();
		List<Contato> contatos = new ArrayList<Contato>();
		while(result.next()) {
			Contato contato = new Contato();
			contato.setNome(result.getString("nome"));
			contato.setEmail(result.getString("email"));
			contato.setEndereco(result.getString("endereco"));
			contatos.add(contato);
		}
		result.close();
		stmt.close();
		return contatos;
	}
	
	public static void fechaConexao(Connection con) {
		try {
			con.close();
		} catch (Exception erro) {
			System.out.println("Erro ao fechar a conexão: " + erro.toString());
		}
	}
	
	
}
