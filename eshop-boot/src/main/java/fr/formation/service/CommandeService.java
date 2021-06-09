package fr.formation.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.ICommandeDao;
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
			//On demande � Hibernate de charger la liste des d�tails pour une commande
			Hibernate.initialize(cmd.getDetails());
			
//			cmd.getDetails();
			
//			for (CommandeDetailProjection cd : cmd.getDetails()) {
//				
//			}
		}
		
		return commandes;
	}
	
	//> Chercher les commandes pour une date entre A et B (avec chargement initial des d�tails dans la DAO)
	public List<CommandeProjection> findAllByDatesFetching(LocalDateTime start, LocalDateTime end) {
		List<CommandeProjection> commandes = this.daoCommande.findAllByDateBetweenFetching(start, end);
		
		return commandes;
	}
}