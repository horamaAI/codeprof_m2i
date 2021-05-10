package fr.formation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestHibernateApplication {
	public static void main(String[] args) {
		//R�cup�rer un PersistenceUnit pour r�cup�rer un EntityManagerFactory
		//D�s qu'on va r�cup�rer l'entityManagerFactory, Hibernate va valider la structure
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");
		
		//R�cup�rer un EntityManager
		EntityManager em = emf.createEntityManager();
		
		
		//Fermer EntityManagerFactory, pour fermer les connexions avec SQL etc.
		emf.close();
	}
}