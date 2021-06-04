package fr.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IAttributDao;
import fr.formation.model.Attribut;

@Service
public class AttributService {
	@Autowired
	private IAttributDao daoAttribut;
	
	public void add(Attribut attribut) {
		//Eventuellement des vérifs ...
		
		this.daoAttribut.save(attribut);
	}
}