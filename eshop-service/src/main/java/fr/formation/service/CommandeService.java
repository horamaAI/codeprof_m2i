package fr.formation.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.ICommandeDao;
import fr.formation.model.Commande;

@Service
public class CommandeService {
	@Autowired
	private ICommandeDao daoCommande;
	
	//> Chercher les commandes pour une date entre A et B
	public List<Commande> findAllByDates(LocalDateTime start, LocalDateTime end) {
		return this.daoCommande.findAllByDateBetween(start, end);
	}
}