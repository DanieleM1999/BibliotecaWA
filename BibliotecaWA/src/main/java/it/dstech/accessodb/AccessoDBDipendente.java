package it.dstech.accessodb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;

import it.dstech.modelli.Dipendente;

//@WebServlet("/accediDipendente")

public class AccessoDBDipendente {

	public Connection con() throws ClassNotFoundException, SQLException {
		ConnessioneDB con = new ConnessioneDB();
		return con.con();
	}

	public HashMap<String, Dipendente> creaMappa() throws ClassNotFoundException, SQLException {
		HashMap<String, Dipendente> mappaDipendenti = new HashMap<>();
		String query = "Select * from dipendente ; ";
		Statement statement = con().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			String username = resultSet.getString("user");
			String pass = resultSet.getString("pass");
			Dipendente d = new Dipendente(username, pass);
			mappaDipendenti.put(username, d);
		}
		return mappaDipendenti;
	}

	public boolean controlloEsistenzaDipendente(String userDipendente) throws ClassNotFoundException, SQLException {
		if (creaMappa().containsKey(userDipendente)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean aggiuntaDipendenteAlDatabase(Dipendente d) throws ClassNotFoundException, SQLException {
		if (!(controlloEsistenzaDipendente(d.getUsernameD()))) {
			String query = "Insert into dipendente (Username,Password) values (?,?) ;";
			PreparedStatement preparedStatement = con().prepareStatement(query);
			preparedStatement.setString(1, d.getUsernameD());
			preparedStatement.setString(2, d.getPassD());
			preparedStatement.execute();
			return true;
		} else {
			return false;
		}
	}

	public boolean AccessoCorretto(String user, String pass) throws ClassNotFoundException, SQLException {
		if (creaMappa().containsKey(user)) {
			if (creaMappa().get(user).getPassD().equals(pass)) {
				return true;
			}
		}
		return false;
	}
}
