package fr.formation.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractDaoHibernate<T> {
	private static EntityManagerFactory emf;
	protected EntityManager em;
	
	public AbstractDaoHibernate() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("EShopUnit");
		}
		
		this.em = emf.createEntityManager();
	}

	public abstract Optional<T> findById(int id);
	
	public T add(T entity) {
		try {
			//Démarrage de la transaction
			this.em.getTransaction().begin();
			
			//Persister
			this.em.persist(entity);
			
			//Commit de la transaction
			this.em.getTransaction().commit();
		}
		
		catch (Exception ex) {
			//On annule la requête si erreur détectée
			this.em.getTransaction().rollback();
		}
		
		return entity;
	}

	public T update(T entity) {
		try {
			//Démarrage de la transaction
			this.em.getTransaction().begin();
			
			//Sauvegarde
			entity = this.em.merge(entity);
			
			//Commit de la transaction
			this.em.getTransaction().commit();
		}
		
		catch (Exception ex) {
			//On annule la requête si erreur détectée
			this.em.getTransaction().rollback();
		}
		
		return entity;
	}

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
}