package fr.formation.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.ICommandeDao;
import fr.formation.model.Commande;
import fr.formation.projection.CommandeDetailProjection;
import fr.formation.projection.CommandeProjection;

@Service
public class CommandeService {
	@Autowired
	private ICommandeDao daoCommande;
	
	//> Chercher les commandes pour une date entre A et B
	@Transactional
	public List<CommandeProjection> findAllByDates(LocalDateTime start, LocalDateTime end) {
		List<CommandeProjection> commandes = this.daoCommande.findAllByDateBetween(start, end);
		
		for (CommandeProjection cmd : commandes) {
			Hibernate.initialize(cmd.getDetails());
		}
		
		return commandes;
	}
}