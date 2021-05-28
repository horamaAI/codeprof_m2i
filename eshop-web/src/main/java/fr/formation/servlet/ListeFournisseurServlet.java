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
		req.setAttribute("test", "Toto");
		
		//On délègue vers la vue
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/liste-fournisseurs.jsp")
			.forward(req, resp);
		
		//On supprime ici l'attribut pour le message de confirmation (solution #1)
		req.getSession().setAttribute("fournisseurAjout", null);
	}
}