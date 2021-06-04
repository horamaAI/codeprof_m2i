package fr.formation.dao;

import java.util.List;

import fr.formation.model.Categorie;
import fr.formation.model.Produit;

public class ProduitDaoHibernate extends AbstractDaoHibernate<Produit> implements IProduitDao {
	public ProduitDaoHibernate() {
		super(Produit.class);
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