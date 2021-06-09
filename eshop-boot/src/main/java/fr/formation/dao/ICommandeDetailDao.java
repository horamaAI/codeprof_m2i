package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.CommandeDetail;
import fr.formation.model.CommandeDetailId;

public interface ICommandeDetailDao extends JpaRepository<CommandeDetail, CommandeDetailId> {

}