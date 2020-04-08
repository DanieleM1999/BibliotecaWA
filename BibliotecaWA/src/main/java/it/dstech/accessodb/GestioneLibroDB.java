package it.dstech.accessodb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import it.dstech.modelli.Libro;

public class GestioneLibroDB {

	public Connection con() throws ClassNotFoundException, SQLException {
		ConnessioneDB con = new ConnessioneDB();
		return con.con();
	}

	public HashMap<String, Libro> creaMappa() throws ClassNotFoundException, SQLException {
		HashMap<String, Libro> mappaLibri = new HashMap<>();
		String query = "Select * from libro ; ";
		Statement statement = con().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
		//	long id = resultSet.getLong("idProdotto");
			String titolo = resultSet.getString("Titolo");
			String autore = resultSet.getString("Autore");
			int quantitaTotale = resultSet.getInt("QuantitaTotale");
			int quantitaNoleggio = resultSet.getInt("QuantitaNoleggio");
			String key = titolo;
			Libro l = new Libro(titolo, autore, quantitaTotale, quantitaNoleggio);
			mappaLibri.put(key, l);
		}
		return mappaLibri;
	}

//	public List<Libro> creaLista() throws ClassNotFoundException, SQLException {
//		List<Libro> listaLibri = new ArrayList<>();
//		String query = "Select * from libro ; ";
//		Statement statement = con().createStatement();
//		ResultSet resultSet = statement.executeQuery(query);
//		while (resultSet.next()) {
//			String titolo = resultSet.getString("Titolo");
//			String autore = resultSet.getString("Autore");
//			int quantitaTotale = resultSet.getInt("QuantitaTotale");
//			int quantitaNoleggio = resultSet.getInt("QuantitaNoleggio");
//			Libro l = new Libro(titolo, autore, quantitaTotale, quantitaNoleggio);
//			listaLibri.add(l);
//		}
//		return listaLibri;
//	}

	public boolean controlloEsistenzaLibro(String titolo) throws ClassNotFoundException, SQLException {
		if (creaMappa().containsKey(titolo)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean aggiuntaLibroDB(Libro l) throws ClassNotFoundException, SQLException {
		if (controlloEsistenzaLibro(l.getTitolo())) {
			return false;
		} else {
			String query = "Insert into libro (Titolo, Autore, QuantitaTotale, QuantitaNoleggio) values (?,?,?,?) ;";
			PreparedStatement preparedStatement = con().prepareStatement(query);
			preparedStatement.setString(1, l.getTitolo());
			preparedStatement.setString(2, l.getAutore());
			preparedStatement.setInt(3, l.getQuantitaTotale());
			preparedStatement.setInt(4, l.getQuantitaNoleggio());
			preparedStatement.execute();
			return true;
		}
	}
//???
	public boolean rimuoviLibro(String titolo) throws ClassNotFoundException, SQLException {
		if (controlloEsistenzaLibro(titolo)) {
			String query = "delete from libro where Titolo=?;";
			PreparedStatement preparedStatement = con().prepareStatement(query);
			preparedStatement.setString(1, "Titolo");
			preparedStatement.execute();
			return true;
		} else {
			return false;
		}
	}

	public int quantitaAttualeTotale(String titolo) throws SQLException, ClassNotFoundException {
		String query = "Select * from libro where Titolo = \"" + titolo + "\" ;";
		
		Statement statement = con().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			return resultSet.getInt("QuantitaTotale");
		}
		return 0;
	}
	
	public int quantitaAttualeNoleggio(String titolo) throws SQLException, ClassNotFoundException {
		String query = "Select * from libro where Titolo = \"" + titolo + "\" ;";
		
		Statement statement = con().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			return resultSet.getInt("QuantitaNoleggio");
		}
		return 0;
	}

	public boolean modificaQuantitaTotale(String titolo, int quantita) throws ClassNotFoundException, SQLException {
		if (controlloEsistenzaLibro(titolo)) {
			int qT = quantitaAttualeTotale(titolo) + quantita;
			String query = "update libro set QuantitaTotale = ? where Titolo = ? ;";
			PreparedStatement preparedStatement = con().prepareStatement(query);
			preparedStatement.setInt(1, qT);
			preparedStatement.setString(2, "Titolo");
			preparedStatement.execute();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean modificaQuantitaNoleggio(String titolo, int quantita) throws ClassNotFoundException, SQLException {
		if (controlloEsistenzaLibro(titolo)) {
			int qN = quantitaAttualeTotale(titolo) + quantita;
			String query = "update libro set QuantitaNoleggio = ? where Titolo = ? ;";
			PreparedStatement preparedStatement = con().prepareStatement(query);
			preparedStatement.setInt(1, qN);
			preparedStatement.setString(2, "Titolo");
			preparedStatement.execute();
			return true;
		} else {
			return false;
		}
	}
	
	


}
