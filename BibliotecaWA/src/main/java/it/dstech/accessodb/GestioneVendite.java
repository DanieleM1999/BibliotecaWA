package it.dstech.accessodb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import it.dstech.modelli.Acquisto;
import it.dstech.modelli.Dipendente;

public class GestioneVendite {

	public Connection con() throws ClassNotFoundException, SQLException, IOException {
		ConnessioneDB con = new ConnessioneDB();
		return con.con();
	}

//	public HashMap<Long, Affitto> mappaLibriAffittati() throws ClassNotFoundException, SQLException, IOException {
//		HashMap<Long, Affitto> mappaLibriAffittati = new HashMap<>();
//		String query = "SELECT * FROM affitto;";
//		Statement statement = con().createStatement();
//		ResultSet resultSet = statement.executeQuery(query);
//		while (resultSet.next()) {
//			String titolo = resultSet.getString(1);
//			String email = resultSet.getString(2);
//			long id = resultSet.getLong(3);
//			Affitto affitto = new Affitto(titolo, email, id);
//			mappaLibriAffittati.put(affitto.getId(), affitto);
//		}
//		return mappaLibriAffittati;
//	}
//
//	public boolean controlloOrdine(String titolo, String user)
//			throws ClassNotFoundException, SQLException, IOException {
//		List<Affitto> listAffittos = new ArrayList<>(mappaLibriAffittati().values());
//		for (Affitto affitto : listAffittos) {
//			if (affitto.getUser().equals(user) && affitto.gettitolo().equals(titolo)) {
//				return true;
//			}
//		}
//		return false;
//	}

//	public boolean affitto(String titolo, String user) throws ClassNotFoundException, SQLException, IOException {
//		GestioneLibroDB gestioneLibri = new GestioneLibroDB();
//		if (controlloOrdine(titolo, user)) {
//			return false;
//		} else {
//			if (gestioneLibri.modificaQuantitaNoleggio(titolo, -1)) {
//				String query = "INSERT INTO affitto (titolo,email) VALUES (?,?);";
//				PreparedStatement statement = con().prepareStatement(query);
//				statement.setString(1, titolo);
//				statement.setString(2, user);
//				statement.execute();
//				return true;
//			} else {
//				return false;
//			}
//		}
//	}

//	public boolean restituzione(String titolo, String user) throws ClassNotFoundException, SQLException, IOException {
//		GestioneLibroDB gestioneLibri = new GestioneLibroDB();
//		if (controlloOrdine(titolo, user)) {
//			if (gestioneLibri.modificaQuantitaNoleggio(titolo, +1)) {
//				String query = "DELETE FROM affitto WHERE titolo = ?;";
//				PreparedStatement statement = con().prepareStatement(query);
//				statement.setString(1, titolo);
//				statement.execute();
//				return true;
//			}
//		}
//		return false;
//	}

	public HashMap<Long, Acquisto> mappaLibriAcquistati() throws ClassNotFoundException, SQLException, IOException {
		HashMap<Long, Acquisto> mappaLibriAcquistati = new HashMap<>();
		String query = "SELECT * FROM acquisto;";
		Statement statement = con().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			long id = resultSet.getLong("idacquisto");
			String user = resultSet.getString("username");
			String titolo = resultSet.getString("titolo");
			String autore = resultSet.getString("autore");
			int quantita = resultSet.getInt("quantita");
			Acquisto acquisto = new Acquisto(id, user, titolo, autore);
			acquisto.setQuantita(quantita);
			mappaLibriAcquistati.put(acquisto.getId(), acquisto);
		}
		return mappaLibriAcquistati;
	}

	public boolean Acquisto(String user, String titolo, String autore, int quantita)
			throws ClassNotFoundException, SQLException, IOException {
		GestioneLibroDB gestioneLibri = new GestioneLibroDB();
		if (gestioneLibri.modificaQuantitaTotale(titolo, -quantita)) {
			String query = "INSERT INTO acquisto(Username,Titolo,Autore,Quantita) VALUES (?,?,?,?);";
			PreparedStatement statement = con().prepareStatement(query);
			statement.setString(1, user);
			statement.setString(2, titolo);
			statement.setString(3, autore);
			statement.setInt(4, quantita);
			statement.execute();
			return true;
		} else {
			return false;
		}
	}
}
