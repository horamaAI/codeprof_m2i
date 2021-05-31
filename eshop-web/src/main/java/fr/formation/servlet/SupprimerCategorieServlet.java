package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.service.CategorieService;

@WebServlet("/supprimer-categorie")
public class SupprimerCategorieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//On r�cup�re l'id de la cat�gorie � supprimer
		String categorieIdString = req.getParameter("id");
		int categorieId = Integer.parseInt(categorieIdString);
		
		CategorieService srvCategorie = new CategorieService();
		
		//On supprime
		srvCategorie.deleteById(categorieId);
		
		//On redirige vers la liste des cat�gories
		resp.sendRedirect("liste-categorie?categorieSupprime=true");
	}
}