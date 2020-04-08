package it.dstech.gestionelibro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menuDipendente")

public class ReindirizzamentoMenuDipendente extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parametro = req.getParameter("SceltaOperazioni");
		if (parametro.equals("aggiungiLibro")) {
			req.getRequestDispatcher("aggiungiLibro.jsp").forward(req, resp);
		} else if (parametro.equals("modificaQuantita")) {
			req.getRequestDispatcher("modificaQuantita.jsp").forward(req, resp);
		}else if (parametro.equals("rimuoviLibro")) {
			req.getRequestDispatcher("rimuoviLibro.jsp").forward(req, resp);
		}else if (parametro.equals("stampaLista")) {
			req.getRequestDispatcher("stampaLista.jsp").forward(req, resp);
		}else if (parametro.equals("acquistaLibro")) {
			req.getRequestDispatcher("acquistaLibro.jsp").forward(req, resp);
		}else if (parametro.equals("affittaLibro")) {
			req.getRequestDispatcher("affittaLibro.jsp").forward(req, resp);
		}else if (parametro.equals("visualizzaAcquisti")) {
			req.getRequestDispatcher("visualizzaAcquisti.jsp").forward(req, resp);
		}else if (parametro.equals("visualizzaPrenotazioni")) {
			req.getRequestDispatcher("visualizzaPrenotazioni.jsp").forward(req, resp);
		}
	}
}