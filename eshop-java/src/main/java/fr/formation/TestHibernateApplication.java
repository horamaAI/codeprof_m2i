package fr.formation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestHibernateApplication {
	public static void main(String[] args) {
		//Récupérer un PersistenceUnit pour récupérer un EntityManagerFactory
		//Dès qu'on va récupérer l'entityManagerFactory, Hibernate va valider la structure
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");
		
		//Récupérer un EntityManager
		EntityManager em = emf.createEntityManager();
		
		
		//Fermer EntityManagerFactory, pour fermer les connexions avec SQL etc.
		emf.close();
	}
}