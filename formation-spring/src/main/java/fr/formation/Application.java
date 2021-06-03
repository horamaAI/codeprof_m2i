package fr.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import fr.formation.config.AppConfig;
import fr.formation.musique.IMusicien;

@Component
public class Application {
	public static void main(String[] args) {
		// Chargement d'un contexte de SPRING
//		ClassPathXmlApplicationContext myContext =
//			new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		AnnotationConfigApplicationContext myContext =
			new AnnotationConfigApplicationContext(AppConfig.class);
		
//		// Récupération d'un bean Musicien
//		IMusicien musicien = myContext.getBean(IMusicien.class);
//		IMusicien musicien2 = myContext.getBean(IMusicien.class);
//		IMusicien musicien3 = myContext.getBean(IMusicien.class);
//		
//		// Manipulation de ce bean (faire jouer le musicien)
//		musicien.jouer();
		
		//EXECUTEZ RUN DANS LE CONTEXTE DE SPRING
		myContext.getBean(Application.class).run();
	}
	
	@Autowired
	private IMusicien musicien;
	
	public void run() {
		musicien.jouer();
	}
}