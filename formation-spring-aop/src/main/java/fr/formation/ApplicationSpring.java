package fr.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.service.ProduitService;

public class ApplicationSpring {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ProduitService srvProduit = myContext.getBean(ProduitService.class);
		
		try {
			srvProduit.findAll();
			System.out.println("-- Directement de l'extérieur");
			srvProduit.findAllDemoProxy();
		}
		
		catch (RuntimeException rex) {
			
		}
	}
}