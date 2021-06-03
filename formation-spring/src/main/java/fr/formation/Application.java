package fr.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.musique.IMusicien;

public class Application {
	public static void main(String[] args) {
		// Chargement d'un contexte de SPRING
//		ClassPathXmlApplicationContext myContext =
//			new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		AnnotationConfigApplicationContext myContext =
			new AnnotationConfigApplicationContext(AppConfig.class);
		
		// Récupération d'un bean Musicien
		IMusicien musicien = myContext.getBean(IMusicien.class);
		
		// Manipulation de ce bean (faire jouer le musicien)
		musicien.jouer();
	}
}