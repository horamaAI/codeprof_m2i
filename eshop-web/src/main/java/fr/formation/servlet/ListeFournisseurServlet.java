package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.service.FournisseurService;

@WebServlet("/liste-fournisseur")
public class ListeFournisseurServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FournisseurService srvFournisseur = new FournisseurService();
		
		//On enregistre la liste de fournisseurs dans le scope Request
		req.setAttribute("fournisseurs", srvFournisseur.findAll());
		
		//On délègue vers la vue
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/liste-fournisseurs.jsp")
			.forward(req, resp);
	}
}