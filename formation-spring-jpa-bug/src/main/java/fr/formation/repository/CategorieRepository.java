package fr.formation.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.formation.dao.ICategorieDao;
import fr.formation.model.Categorie;

@Repository
public class CategorieRepository implements ICategorieDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Categorie> findAll() {
		//Lister toutes les Catégories
		List<Categorie> categories = em
				.createQuery("select c from Categorie c", Categorie.class)
				.getResultList();
		
		return categories;
	}

	@Override
	public Categorie findById(int id) {
		return em.find(Categorie.class, id);
	}

	@Override
	@Transactional
	public Categorie add(Categorie entity) {
		em.persist(entity);
		
		return entity;
	}

	@Override
	@Transactional
	public Categorie save(Categorie entity) {
		entity = em.merge(entity);
		
		return entity;
	}

	@Override
	@Transactional
	public boolean deleteById(int id) {
		em.createQuery("delete from Categorie c where c.id = ?1")
			.setParameter(1, id)
			.executeUpdate();
		
		return true;
	}
}