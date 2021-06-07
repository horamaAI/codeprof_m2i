package fr.formation.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Initialisation du contexte des DAO ...");
		
		//On instancie toutes nos DAO (soit en créant le service, soit en appelant la Factory)
//		new ProduitService();
//		DAOFactory.createFournisseurDao();
//		DAOFactory.createCategoryDao();
//		DAOFactory.createAttributDao();
	}
}