package fr.formation.dao;

import fr.formation.model.Categorie;

public class CategorieDaoHibernate extends AbstractDaoHibernate<Categorie> implements ICategorieDao {
	public CategorieDaoHibernate() {
		super(Categorie.class);
	}
}