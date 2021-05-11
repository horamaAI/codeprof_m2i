package fr.formation.dao;

import java.util.List;
import java.util.Optional;

import fr.formation.model.Categorie;
import fr.formation.model.Produit;

public class ProduitDaoHibernate extends AbstractDaoHibernate<Produit> implements IProduitDao {
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