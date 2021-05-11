package fr.formation.dao;

import java.util.List;
import java.util.Optional;

import fr.formation.model.Categorie;

public class CategorieDaoHibernate extends AbstractDaoHibernate<Categorie> implements ICategorieDao {
	@Override
	public List<Categorie> findAll() {
		return this.em
			.createQuery("select c from Categorie c", Categorie.class)
			.getResultList();
	}

	@Override
	public Optional<Categorie> findById(int id) {
		return Optional.ofNullable(
			this.em.find(Categorie.class, id)
		);
	}
}