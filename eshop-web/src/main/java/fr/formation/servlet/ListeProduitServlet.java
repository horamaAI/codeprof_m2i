package fr.formation.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Produit;
import fr.formation.service.ProduitService;

@WebServlet("/liste-produit")
public class ListeProduitServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//On fabrique les produits
//		List<Produit> mesProduits = new ArrayList<>();
//		
//		Produit p1 = new Produit();
//		p1.setId(1);
//		p1.setLibelle("Parachute de France");
//		p1.setPrix(new BigDecimal(6999));
//		
//		Produit p2 = new Produit();
//		p2.setId(2);
//		p2.setLibelle("Combinaison été");
//		p2.setPrix(new BigDecimal(99));
//		
//		Produit p3 = new Produit();
//		p3.setId(3);
//		p3.setLibelle("Combinaison hiver");
//		p3.setPrix(new BigDecimal(200));
//
//		mesProduits.add(p1);
//		mesProduits.add(p2);
//		mesProduits.add(p3);
		
		//On récupère le service
		ProduitService srvProduit = new ProduitService();
		
		//On récupère la liste des produits
		List<Produit> mesProduits = srvProduit.findAll();
		
		//On ajoute la liste au scope Request
		req.setAttribute("produits", mesProduits);
		
		//On délègue
		this
			.getServletContext()
			.getRequestDispatcher("/WEB-INF/liste-produits.jsp")
			.forward(req, resp);
	}
}