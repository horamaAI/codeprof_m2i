package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Categorie;

public interface ICategorieDao extends JpaRepository<Categorie, Integer> {

}