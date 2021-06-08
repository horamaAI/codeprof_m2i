package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Commande;

public interface ICommandeDao extends JpaRepository<Commande, Integer> {
	
}