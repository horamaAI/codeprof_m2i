package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Attribut;

public interface IAttributDao extends JpaRepository<Attribut, Integer> {

}