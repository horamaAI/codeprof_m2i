package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Categorie;
import fr.formation.service.CategorieService;

@WebServlet("/ajouter-categorie")
public class AjouterCategorieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategorieService srvCategorie = new CategorieService();
		req.setAttribute("categories", srvCategorie.findAll());
		
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/form-categorie.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//On récupère les informations
		String libelle = req.getParameter("libelle");
		String description = req.getParameter("description");
		String parentIdString = req.getParameter("parentId");
		
		int parentId = Integer.parseInt(parentIdString);
		
		//On fabrique la catégorie
		Categorie maCategorie = new Categorie();

		maCategorie.setLibelle(libelle);
		maCategorie.setDescription(description);
		
		if (parentId > 0) {
			Categorie maCategorieParent = new Categorie();
			
			maCategorieParent.setId(parentId);
			maCategorie.setParent(maCategorieParent);
		}
		
		//On sauvegarde
		CategorieService srvCategorie = new CategorieService();
		srvCategorie.add(maCategorie);
		
		//On redirige vers la liste des catégories
		resp.sendRedirect("liste-categorie?categorieAjout=true");
	}
}