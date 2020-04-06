package it.dstech.gestioneutenti;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.dstech.accessodb.AccessoDBCliente;
import it.dstech.modelli.Cliente;

@WebServlet("/registraCliente")

public class RegistraCliente extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("messaggio", "hai tentato di accedere manualmente");
		req.getRequestDispatcher("Login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		Cliente c = new Cliente(user, pass);
		
		
		AccessoDBCliente accessoC = new AccessoDBCliente();
		try {
			if (accessoC.aggiuntaClienteAlDatabase(c)) {
				req.getRequestDispatcher("MenuCliente.jsp").forward(req, resp);
			} else {
				req.setAttribute("messaggio",
						"Possibili errori:\n-Username gia utilizzato prova a cambiarlo\n-Possibile errore con l'inserimento dati");
				req.getRequestDispatcher("HomeCliente.jsp").forward(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
