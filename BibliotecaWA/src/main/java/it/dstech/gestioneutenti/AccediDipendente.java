package it.dstech.gestioneutenti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.accessodb.AccessoDBDipendente;

@WebServlet("/accediDipendente")

public class AccediDipendente extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "hai tentato di accedere manualmente");
		req.getRequestDispatcher("Start.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccessoDBDipendente accessoDB = new AccessoDBDipendente();
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		try {
			if (accessoDB.AccessoCorretto(user, pass)) {
				req.getRequestDispatcher("MenuDipendente.jsp").forward(req, resp);
			} else {
				req.setAttribute("messaggio", "Possibile errore nell'Inserimento Dati riprova");
				req.getRequestDispatcher("HomeDipendente.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
