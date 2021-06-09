package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.formation.model.Attribut;

@RepositoryRestResource(path = "attribut")
public interface IAttributDao extends JpaRepository<Attribut, Integer> {

}