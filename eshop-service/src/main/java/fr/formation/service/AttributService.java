package fr.formation.service;

import fr.formation.dao.DAOFactory;
import fr.formation.dao.IAttributDao;
import fr.formation.model.Attribut;

public class AttributService {
	private IAttributDao daoAttribut = DAOFactory.createAttributDao();
	
	public void add(Attribut attribut) {
		//Eventuellement des vérifs ...
		
		this.daoAttribut.add(attribut);
	}
}