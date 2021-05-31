package fr.formation.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

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

@WebServlet("/modifier-produit")
public class ModifierProduitServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Récupérer l'id produit
		String produitIdString = req.getParameter("id");
		int produitId = Integer.parseInt(produitIdString);
		
		//Récupérer le produit
		ProduitService srvProduit = new ProduitService();
		Produit monProduit = srvProduit.findById(produitId);
		
		//Récupérer les fournisseurs et les catégories
		FournisseurService srvFournisseur = new FournisseurService();
		CategorieService srvCategorie = new CategorieService();

		List<Fournisseur> mesFournisseurs = srvFournisseur.findAll();
		List<Categorie> mesCategories = srvCategorie.findAll();
		
		//Injecter dans le scope request
		req.setAttribute("produit", monProduit);
		req.setAttribute("fournisseurs", mesFournisseurs);
		req.setAttribute("categories", mesCategories);
		
		//Déléguer vers la vue
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/form-produit.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//On récupère les paramètres
		String produitIdString = req.getParameter("id");
		String libelle = req.getParameter("libelle");
		String prixString = req.getParameter("prix");
		String prixAchatString = req.getParameter("prixAchat");
		String fournisseurIdString = req.getParameter("fournisseurId");
		String categorieIdString = req.getParameter("categorieId");

		int produitId = Integer.parseInt(produitIdString);
		BigDecimal prix = new BigDecimal(prixString);
		BigDecimal prixAchat = new BigDecimal(prixAchatString);
		int fournisseurId = Integer.parseInt(fournisseurIdString);
		int categorieId = Integer.parseInt(categorieIdString);
		
		//On constitue le produit (solution #2 pour la modification - #1 dans ModifierFournisseurServlet)
		//Important solution #2 (new produit), il faut bien récupérer TOUTES les infos depuis le formulaire
		Produit monProduit = new Produit();
		
		monProduit.setId(produitId); //Important sinon Hibernate va en faire un ajout
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
		srvProduit.update(monProduit);
		
		//On redirige vers la liste des produits
		resp.sendRedirect("liste-produit?produitModifie=true");
	}
}