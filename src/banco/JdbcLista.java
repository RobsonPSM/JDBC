package banco;

import java.sql.SQLException;
import java.util.List;

import dao.ContatoDao;
import modelo.Contato;

public class JdbcLista {
	public static void main(String[] args) {	
		try {
			ContatoDao cdao;
			cdao = new ContatoDao();
			List<Contato> contatos = cdao.getLista();
			
			for (Contato contato : contatos) {
				System.out.println("Nome: " + contato.getNome());
				System.out.println("Email: " + contato.getEmail());
				System.out.println("Endereço: " + contato.getEndereco());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
