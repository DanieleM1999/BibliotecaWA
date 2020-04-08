package it.dstech.gestionelibro;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.accessodb.GestioneLibroDB;
import it.dstech.modelli.Libro;

public class AggiungiLibro extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "hai tentato di accedere manualmente");
		req.getRequestDispatcher("Start.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// long iD = Long.parseLong(req.getParameter("iD"));
		String titolo = req.getParameter("Titolo");
		String autore = req.getParameter("Autore");
		int quantitaTotale = Integer.parseInt(req.getParameter("QuantitaTotale"));
		int quantitaNoleggio = Integer.parseInt(req.getParameter("QuantitaNoleggio"));
		Libro l = new Libro(titolo, autore, quantitaTotale, quantitaNoleggio);
		GestioneLibroDB gest = new GestioneLibroDB();
		try {
			if (gest.aggiuntaLibroDB(l)) {
				req.setAttribute("messaggio", "Prodotto aggiunto correttamente...");
				req.getRequestDispatcher("Fine.jsp").forward(req, resp);
			} else {
				req.setAttribute("messaggio", "possibile errore nel inserimento dati; oppure prodotto già esistente");
				req.getRequestDispatcher("MenuDipendente.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
