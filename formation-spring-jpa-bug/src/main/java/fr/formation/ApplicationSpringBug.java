package fr.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.service.CategorieService;
import fr.formation.service.FournisseurService;

public class ApplicationSpringBug {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		FournisseurService srvFournisseur = context.getBean(FournisseurService.class);
		CategorieService srvCategorie = context.getBean(CategorieService.class);
		
		srvFournisseur.add();
		srvFournisseur.findAll();
		
		srvCategorie.update();
		srvCategorie.findAll();
		
		context.close();
	}
}