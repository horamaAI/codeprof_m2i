package fr.formation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.model.Categorie;
import fr.formation.model.Commande;
import fr.formation.model.Produit;
import fr.formation.service.CommandeService;
import fr.formation.service.ProduitService;

public class ApplicationSpring {
	public static void main(String[] args) {
		//Chargement du contexte de SPRING
		AnnotationConfigApplicationContext myContext =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		//Récupérer le service ProduitService
//		ProduitService srvProduit = myContext.getBean(ProduitService.class);
//		
//		//Manipuler le service pour récupérer la liste des produits
//		Categorie maCategorie = new Categorie();
//		
//		maCategorie.setId(1);
//		
//		List<Produit> mesProduits = srvProduit.findAllByCategorie(maCategorie);
//		
//		//Parcours de la liste
//		for (Produit produit : mesProduits) {
//			System.out.println(produit.getId() + produit.getLibelle());
//		}
		
		
		CommandeService srvCommande = myContext.getBean(CommandeService.class);
		for (Commande cmd : srvCommande.findAllByDates(LocalDateTime.now().plusDays(-100), LocalDateTime.now().plusDays(2))) {
			System.out.println(cmd.getId());
		}
		
//		srvProduit.deleteById(6);
	}
}