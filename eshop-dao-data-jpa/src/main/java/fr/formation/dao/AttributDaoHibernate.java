package fr.formation.dao;

import fr.formation.model.Attribut;

public class AttributDaoHibernate extends AbstractDaoHibernate<Attribut> implements IAttributDao {
	public AttributDaoHibernate() {
		super(Attribut.class);
	}
}