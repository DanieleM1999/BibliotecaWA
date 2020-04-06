package it.dstech.accessodb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;

import it.dstech.modelli.Cliente;

public class AccessoDBCliente {

	public Connection con() throws ClassNotFoundException, SQLException {
		ConnessioneDB con = new ConnessioneDB();
		return con.con();
	}

	public HashMap<String, Cliente> creaMappa() throws ClassNotFoundException, SQLException {
		HashMap<String, Cliente> mappaClienti = new HashMap<>();
		String query = "Select * from biblioteca.cliente ; ";
		Statement statement = con().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			String username = resultSet.getString("Username");
			String pass = resultSet.getString("pass");
			Cliente c = new Cliente(username, pass);
			mappaClienti.put(username, c);
		}
		return mappaClienti;
	}

	public boolean controlloEsistenzaCliente(String userCliente) throws ClassNotFoundException, SQLException {
		if (creaMappa().containsKey(userCliente)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean aggiuntaClienteAlDatabase(Cliente c) throws ClassNotFoundException, SQLException {
		if (!(controlloEsistenzaCliente(c.getUsernameC()))) {
			String query = "Insert into utenti (Username,pass) values (?,?) ;";
			PreparedStatement preparedStatement = con().prepareStatement(query);
			preparedStatement.setString(1, c.getUsernameC());
			preparedStatement.setString(2, c.getPassC());
			preparedStatement.execute();
			return true;
		} else {
			return false;
		}
	}

	public boolean AccessoCorretto(String user, String pass) throws ClassNotFoundException, SQLException {
		if (creaMappa().containsKey(user)) {
			if (creaMappa().get(user).getPassC().equals(pass)) {
				return true;
			}
		}
		return false;
	}
}
