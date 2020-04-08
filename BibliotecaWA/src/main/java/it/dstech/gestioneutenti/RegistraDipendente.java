package it.dstech.gestioneutenti;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.accessodb.AccessoDBDipendente;
import it.dstech.modelli.Dipendente;

@WebServlet("/registraDipendente")

public class RegistraDipendente extends HttpServlet {
//s
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "hai tentato di accedere manualmente");
		req.getRequestDispatcher("Start.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		Dipendente d = new Dipendente(user, pass);
		
		
		AccessoDBDipendente accessoD = new AccessoDBDipendente();
		try {
			if (accessoD.aggiuntaDipendenteAlDatabase(d)) {
				req.getRequestDispatcher("MenuDipendente.jsp").forward(req, resp);
			} else {
				req.setAttribute("messaggio",
						"Possibili errori:\n-Username gia utilizzato prova a cambiarlo\n-Possibile errore con l'inserimento dati");
				req.getRequestDispatcher("HomeDipendente.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
