package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.service.CategorieService;

@WebServlet("/liste-categorie")
public class ListeCategorieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//On récupère la liste des catégories et on la donne au scope request
		CategorieService srvCategorie = new CategorieService();
		req.setAttribute("categories", srvCategorie.findAll());
		
		//On délègue vers la vue
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/liste-categories.jsp")
			.forward(req, resp);
	}
}