package fr.formation.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.formation.model.Categorie;
import fr.formation.model.Produit;

@Repository //On donne à SPRING sa gestion
public class ProduitDaoRepository implements IProduitDao {
	@PersistenceContext //On demande à SPRING l'EntityManager
	private EntityManager em;
	
	@Override
	public List<Produit> findAll() {
		return this
				.em
				.createQuery("select p from Produit p", Produit.class)
				.getResultList();
	}

	@Override
	public Optional<Produit> findById(int id) {
		return Optional.ofNullable(
			this.em.find(Produit.class, id)
		);
	}

	@Override
	@Transactional
	public Produit add(Produit entity) {
		this.em.persist(entity);
		
		return entity;
	}

	@Override
	@Transactional
	public Produit update(Produit entity) {
		return this.em.merge(entity);
	}

	@Override
	@Transactional
	public boolean deleteById(int id) {
		this.em
			.createQuery("delete Produit p where p.id = ?1")
			.setParameter(1, id)
			.executeUpdate();
		
		return true;
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