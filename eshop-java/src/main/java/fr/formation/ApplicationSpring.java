package fr.formation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.projection.CommandeDetailProjection;
import fr.formation.projection.CommandeProjection;
import fr.formation.projection.ProduitProjection;
import fr.formation.service.CommandeService;
import fr.formation.service.ProduitService;

public class ApplicationSpring {
	public static void main(String[] args) {
		//Chargement du contexte de SPRING
		AnnotationConfigApplicationContext myContext =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		//Récupérer le service ProduitService
		ProduitService srvProduit = myContext.getBean(ProduitService.class);
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
		for (CommandeProjection cmd : srvCommande.findAllByDates(LocalDateTime.now().plusDays(-100), LocalDateTime.now().plusDays(2))) {
			System.out.println(cmd.getId() + " " + cmd.getClientNom());
			
			for (CommandeDetailProjection detail : cmd.getDetails()) {
				System.out.println(detail.getPrixUnitaire());
			}
		}
		
		for (ProduitProjection p : srvProduit.findAllProjected()) {
//			System.out.println(p.getId() + " - " + p.getLibelle() + ", " + p.getFournisseurNom());
			System.out.println(p.getId() + " - " + p.getLibelle() + ", " + p.getFournisseur().getNom() + " " + p.getFournisseurVille() + "---" + p.getFournisseurAdresseComplete());
		}
		
//		srvProduit.deleteById(6);
	}
}