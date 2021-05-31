package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.service.ProduitService;

@WebServlet("/supprimer-produit")
public class SupprimerProduitServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String produitIdString = req.getParameter("id");
		int produitId = Integer.parseInt(produitIdString);
		ProduitService srvProduit = new ProduitService();
		
		//On supprime
		srvProduit.deleteById(produitId);
		
		//Rediriger vers la liste des produits
		resp.sendRedirect("liste-produit");
	}
}