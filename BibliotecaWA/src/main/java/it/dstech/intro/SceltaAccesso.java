package it.dstech.intro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")

public class SceltaAccesso extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parametro = req.getParameter("SceltaOperazioni");
		if (parametro.equals("HomeDipendente")) {
			req.getRequestDispatcher("HomeDipendente.jsp").forward(req, resp);
		} else if (parametro.equals("HomeCliente")) {
			req.getRequestDispatcher("HomeCliente.jsp").forward(req, resp);
		}
	}
}