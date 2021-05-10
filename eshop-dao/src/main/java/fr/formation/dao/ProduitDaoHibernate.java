package fr.formation.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.formation.model.Categorie;
import fr.formation.model.Produit;

public class ProduitDaoHibernate implements IProduitDao {
	private EntityManager em;
	
	public ProduitDaoHibernate() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");
		this.em = emf.createEntityManager();
	}

	@Override
	public List<Produit> findAll() {
		return this.em
			.createQuery("select p from Produit p", Produit.class)
			.getResultList();
	}

	@Override
	public Optional<Produit> findById(int id) {
//		try {
//			return Optional.of(
//				this.em
//					.createQuery("select p from Produit p where p.id = ?1", Produit.class)
//					.setParameter(1, id)
//					.getSingleResult()
//			);
//		}
//		
//		catch (Exception ex) {
//			return Optional.empty();
//		}
		
//		Produit produit = this.em.find(Produit.class, id);
//		
//		if (produit == null) {
//			return Optional.empty();
//		}
//		
//		return Optional.of(produit);
		
		return Optional.ofNullable(
			this.em.find(Produit.class, id)
		);
	}

	@Override
	public Produit add(Produit entity) {
		//Démarrage de la transaction
		this.em.getTransaction().begin();
		
		//Persister
		this.em.persist(entity);
		
		//Commit de la transaction
		this.em.getTransaction().commit();
		
		return entity;
	}

	@Override
	public Produit update(Produit entity) {
		//Démarrage de la transaction
		this.em.getTransaction().begin();
		
		//Sauvegarde
		entity = this.em.merge(entity);
		
		//Commit de la transaction
		this.em.getTransaction().commit();
		
		return entity;
	}

	@Override
	public boolean deleteById(int id) {
		//Démarrage de la transaction
		this.em.getTransaction().begin();
		
		try {
			this.em.remove(
				this.findById(id)
			);

			//Commit de la transaction
			this.em.getTransaction().commit();
			
			return true;
		}
		
		catch (Exception ex) {
			//Rollback de la transaction (annuler les changements)
			this.em.getTransaction().rollback();
			
			return false;
		}
	}

	@Override
	public List<Produit> findAllByCategorie(Categorie categorie) {
		return this.em
			.createQuery("select p from Produit p where p.categorie = ?1", Produit.class)
			.setParameter(1, categorie)
			.getResultList();
	}

	@Override
	public List<Produit> findAllByCategorieId(int categorieId) {
		return this.em
			.createQuery("select p from Produit p where p.categorie.id = ?1", Produit.class)
			.setParameter(1, categorieId)
			.getResultList();
	}
}