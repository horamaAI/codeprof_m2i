package fr.formation.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Categorie;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.service.CategorieService;
import fr.formation.service.FournisseurService;
import fr.formation.service.ProduitService;

@WebServlet("/ajouter-produit")
public class AjouterProduitServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FournisseurService srvFournisseur = new FournisseurService();
		CategorieService srvCategorie = new CategorieService();

		req.setAttribute("fournisseurs", srvFournisseur.findAll());
		req.setAttribute("categories", srvCategorie.findAll());
		
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/form-produit.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//On récupère les paramètres
		String libelle = req.getParameter("libelle");
		String prixString = req.getParameter("prix");
		String prixAchatString = req.getParameter("prixAchat");
		String fournisseurIdString = req.getParameter("fournisseurId");
		String categorieIdString = req.getParameter("categorieId");

		BigDecimal prix = new BigDecimal(prixString);
		BigDecimal prixAchat = new BigDecimal(prixAchatString);
		int fournisseurId = Integer.parseInt(fournisseurIdString);
		int categorieId = Integer.parseInt(categorieIdString);
		
		//On constitue le produit
		Produit monProduit = new Produit();
		
		monProduit.setLibelle(libelle);
		monProduit.setPrix(prix);
		monProduit.setPrixAchat(prixAchat);
		
		//On associe le fournisseur & la catégorie au produit
		
		//Solution #1 pour l'association
		Categorie maCategorie = new Categorie();
		maCategorie.setId(categorieId);
		monProduit.setCategorie(maCategorie);
		
		//Solution #2 pour l'association
		FournisseurService srvFournisseur = new FournisseurService();
		Fournisseur monFournisseur = srvFournisseur.findById(fournisseurId);
		monProduit.setFournisseur(monFournisseur);
		
		//On sauvegarde
		ProduitService srvProduit = new ProduitService();
		srvProduit.add(monProduit);
		
		//On redirige vers la liste des produits
		resp.sendRedirect("liste-produit?produitAjout=true");
	}
}