package fr.formation.dao;

import java.util.List;
import java.util.Optional;

import fr.formation.model.Attribut;

public class AttributDaoHibernate extends AbstractDaoHibernate<Attribut> implements IAttributDao {
	@Override
	public List<Attribut> findAll() {
		return this.em
					.createQuery("select a from Attribut a", Attribut.class)
					.getResultList();
	}

	@Override
	public Optional<Attribut> findById(int id) {
		return Optional.ofNullable(
			this.em.find(Attribut.class, id)
		);
	}
}