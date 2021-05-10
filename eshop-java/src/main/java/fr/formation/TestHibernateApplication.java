package fr.formation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;

public class TestHibernateApplication {
	public static void main(String[] args) {
		//Récupérer un PersistenceUnit pour récupérer un EntityManagerFactory
		//Dès qu'on va récupérer l'entityManagerFactory, Hibernate va valider la structure
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");
		
		//Récupérer un EntityManager
		EntityManager em = emf.createEntityManager();
		
		Produit monProduit = em.find(Produit.class, 1);
		System.out.println(monProduit.getLibelle());
		System.out.println(monProduit.getCategorie().getLibelle());
		
		List<Produit> mesProduits = em
			.createQuery("select p from Produit p", Produit.class)
			.getResultList();
		
		for (Produit p : mesProduits) {
			System.out.println(p.getId() + " - " + p.getLibelle());
		}
		
		List<Produit> mesProduits2 = em
//			.createQuery("select p from Produit p where p.fournisseur.id = :fournisseurId", Produit.class)
			.createQuery("select p from Produit p where p.fournisseur.id = ?1", Produit.class)
//			.setParameter("fournisseurId", 1)
			.setParameter(1, 1)
			.getResultList();
		
		for (Produit p : mesProduits2) {
			System.out.println(p.getId() + " - " + p.getLibelle());
		}
		
		//fetch : permet de rattacher la liste des produits au fournisseur
		List<Fournisseur> mesFournisseurs = em
			.createQuery("select distinct f from Fournisseur f left join fetch f.produits", Fournisseur.class)
			.getResultList();
		
		em.close();
		
		for (Fournisseur f : mesFournisseurs) {
			System.out.println(f.getId() + " - " + f.getNom() + ", " + f.getProduits().size());
		}
		
		//Fermer EntityManagerFactory, pour fermer les connexions avec SQL etc.
		emf.close();
	}
}