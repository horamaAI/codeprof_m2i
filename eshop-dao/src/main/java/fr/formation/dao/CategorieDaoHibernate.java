package fr.formation.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.formation.model.Categorie;

public class CategorieDaoHibernate implements ICategorieDao {
	private EntityManager em;
	
	public CategorieDaoHibernate() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EShopUnit");
		this.em = emf.createEntityManager();
	}
	
	@Override
	public List<Categorie> findAll() {
		return this.em
			.createQuery("select c from Categorie c", Categorie.class)
			.getResultList();
	}

	@Override
	public Optional<Categorie> findById(int id) {
		return Optional.of(
			this.em.find(Categorie.class, id)
		);
	}

	@Override
	public Categorie add(Categorie entity) {
		//Démarrage de la transaction
		this.em.getTransaction().begin();
		
		//Persister
		this.em.persist(entity);
		
		//Commit de la transaction
		this.em.getTransaction().commit();
		
		return entity;
	}

	@Override
	public Categorie update(Categorie entity) {
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
			//Solution #1 : utiliser remove de EntityManager, en créant une Catégorie
			Categorie categorie = new Categorie();
			categorie.setId(id);
			
			this.em.remove(
				this.em.merge(categorie)
			);
	
			//Solution #2 : utiliser remove de EntityManager, en utilisant le findById
//			this.em.remove(
//				this.findById(id)
//			);
//			
//			//Solution #3 : utiliser une requête JPQL
//			this.em
//				.createQuery("delete from Categorie c where c.id = ?1")
//				.setParameter(1, id)
//				.executeUpdate();

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
}