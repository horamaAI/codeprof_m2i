package fr.formation;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.model.Produit;
import fr.formation.service.ProduitService;

public class ApplicationSpring {
	public static void main(String[] args) {
		//Chargement du contexte de SPRING
		AnnotationConfigApplicationContext myContext =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		//Récupérer le service ProduitService
		ProduitService srvProduit = myContext.getBean(ProduitService.class);
		
		//Manipuler le service pour récupérer la liste des produits
		List<Produit> mesProduits = srvProduit.findAll();
		
		//Parcours de la liste
		for (Produit produit : mesProduits) {
			System.out.println(produit.getId() + produit.getLibelle());
		}
		
//		srvProduit.deleteById(6);
	}
}