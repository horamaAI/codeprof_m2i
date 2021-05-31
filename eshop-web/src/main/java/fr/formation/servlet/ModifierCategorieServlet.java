package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Categorie;
import fr.formation.service.CategorieService;

@WebServlet("/modifier-categorie")
public class ModifierCategorieServlet extends PrincipaleServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//On r�cup�re l'id de la cat�gorie � modifier
//		String categorieIdString = req.getParameter("id");
//		int categorieId = Integer.parseInt(categorieIdString);
		int categorieId = this.getIntegerParameter("id");
		
		//On r�cup�re la cat�gorie et on l'injecte dans le scope request
//		CategorieService srvCategorie = new CategorieService();
		CategorieService srvCategorie = this.createService(CategorieService.class);
		
		req.setAttribute("categorie", srvCategorie.findById(categorieId));
		
		//On r�cup�re la liste des cat�gories et on l'injecte dans le scope request
		req.setAttribute("categories", srvCategorie.findAll());
		
		//On d�l�gue vers la vue
		this.delegate("form-categorie");
		
//		this.getServletContext()
//			.getRequestDispatcher("/WEB-INF/form-categorie.jsp")
//			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//On r�cup�re l'id de la cat�gorie � modifier
		String categorieIdString = req.getParameter("id");
		int categorieId = Integer.parseInt(categorieIdString);
		
		//On r�cup�re les informations
		String libelle = req.getParameter("libelle");
		String description = req.getParameter("description");
		String parentIdString = req.getParameter("parentId");
		int parentId = Integer.parseInt(parentIdString);
		
		//On r�cup�re la cat�gorie � modifier
		CategorieService srvCategorie = new CategorieService();
		Categorie maCategorie = srvCategorie.findById(categorieId);
		
		//On r�affecter les infos
		maCategorie.setLibelle(libelle);
		maCategorie.setDescription(description);
		
		if (parentId > 0) {
			if (parentId != categorieId) {
				Categorie maCategorieParent = new Categorie();
				
				maCategorieParent.setId(parentId);
				maCategorie.setParent(maCategorieParent);
			}
		}
		
		else {
			maCategorie.setParent(null); //On enl�ve la cat�gorie parent
		}
		
		//On sauvegarde
		srvCategorie.update(maCategorie);
		
		//On redirige vers la liste des cat�gories
		resp.sendRedirect("liste-categorie?categorieModifie=true");
	}
}