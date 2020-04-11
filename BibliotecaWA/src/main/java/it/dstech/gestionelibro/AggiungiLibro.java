package it.dstech.gestionelibro;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.accessodb.GestioneLibroDB;
import it.dstech.modelli.Libro;
@WebServlet("/aggiungiLibro")
public class AggiungiLibro extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "hai tentato di accedere manualmente");
		req.getRequestDispatcher("Start.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// long iD = Long.parseLong(req.getParameter("iD"));
		String titolo = req.getParameter("titolo");
		String autore = req.getParameter("autore");
		int quantitaTotale = Integer.parseInt(req.getParameter("qntt"));
		int quantitaNoleggio = Integer.parseInt(req.getParameter("qntn"));
		Libro l = new Libro(titolo, autore, quantitaTotale, quantitaNoleggio);
		GestioneLibroDB gest = new GestioneLibroDB();
		try {
			if (gest.aggiuntaLibroDB(l)) {
				req.setAttribute("messaggio", "libro aggiunto correttamente...");
				req.getRequestDispatcher("FineD.jsp").forward(req, resp);
			} else {
				req.setAttribute("messaggio", "possibile errore nel inserimento dati; oppure prodotto già esistente");
				req.getRequestDispatcher("MenuDipendente.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
