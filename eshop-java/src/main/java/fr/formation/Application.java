package fr.formation;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import fr.formation.exception.IdMustBePositiveException;
import fr.formation.model.Attribut;
import fr.formation.model.AttributType;
import fr.formation.model.Categorie;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.service.AttributService;
import fr.formation.service.CategorieService;
import fr.formation.service.FournisseurService;
import fr.formation.service.ProduitService;

public class Application {
	public static void main(String[] args) {
//		daoCategorie();
//		daoProduit();
//		updateProduit();
//		addFournisseur();
//		addProduit();
		addAttribut();
	}
	
	public static void addAttribut() {
		AttributService srvAttribut = new AttributService();
		ProduitService srvProduit = new ProduitService();
		
		//Récupérer un produit
		Produit produit = srvProduit.findById(2);
		
		//Créer un attribut
		Attribut attribut = new Attribut();
		
		//Affecte ses informations
		attribut.setProduit(produit);
		attribut.setType(AttributType.COULEUR);
		attribut.setValeur("ROUGE");
		
		//Sauvegarder l'attribut
		srvAttribut.add(attribut);
	}
	
	public static void addProduit() {
		FournisseurService srvFournisseur = new FournisseurService();
		CategorieService srvCategorie = new CategorieService();
		ProduitService srvProduit = new ProduitService();
		
		//Récupérer une catégorie
		Categorie categorie = srvCategorie.findById(3);
		
		//Récupérer un fournisseur
		Fournisseur fournisseur = srvFournisseur.findById(2);
		
		//Créer un produit
		Produit produit = new Produit();
		
		//Affecter ses informations
		produit.setCategorie(categorie);
		produit.setFournisseur(fournisseur);
		
		produit.setLibelle("PRODUIT FROM JAVA HIB AVEC INFOS");
		produit.setPrix(new BigDecimal(100));
		produit.setPrixAchat(new BigDecimal(10));
		produit.setDescription("Une petite description ...");
		produit.setImage("url de l'image");
		produit.setStock(5);
		
		//Sauvegarde le produit en base de données
		srvProduit.add(produit);
	}
	
	public static void addFournisseur() {
		FournisseurService srvFournisseur = new FournisseurService();
		
		//Fabrication du fournisseur, avec ses infos
		Fournisseur fournisseur = new Fournisseur();
		
		fournisseur.setNom("C-Discount");
		
		//Sauvegarde
		srvFournisseur.add(fournisseur);
	}
	
	
	public static void updateProduit() {
		ProduitService srvProduit = new ProduitService();
		
		//Récupérer le produit
		Produit produit = srvProduit.findById(1);
		
		//Modifier les informations
		produit.setLibelle("PRODUIT EDITE DEPUIS JAVA");
		
		//Sauvegarde du produit
		srvProduit.update(produit);
	}
	
	public static void daoCategorie() {
		CategorieService service = new CategorieService();
		
		for (Categorie c : service.findAll()) {
			System.out.println(c.getId() + " " + c.getLibelle());
		}

		try {
			Categorie maCategorie = service.findById(1);
			
			System.out.println(maCategorie.getId() + " - " + maCategorie.getLibelle());
		}
		
		catch (IdMustBePositiveException idex) {
			System.out.println("L'identifiant n'est pas strictement > 0 ...");
		}
		
		catch (NoSuchElementException nex) {
			System.out.println("Cette catégorie n'existe pas ...");
		}
	}
	
	public static void daoProduit() {
		ProduitService service = new ProduitService();
		
		List<Produit> produits = service.findAll();
		
		for (Produit p : produits) {
			System.out.println(p.getId() + " " + p.getLibelle());
		}

		try {
			Produit monProduit = service.findById(50);
			
			System.out.println(monProduit.getId() + " - " + monProduit.getLibelle());
		}
		
		catch (IdMustBePositiveException idex) {
			System.out.println("L'identifiant n'est pas strictement > 0 ...");
		}
		
		catch (NoSuchElementException nex) {
			System.out.println("Ce produit n'existe pas ...");
		}
	}
}