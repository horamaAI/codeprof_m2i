package fr.formation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Client;

public interface IClientDao extends JpaRepository<Client, Integer> {
	public Optional<Client> findByEmail(String email);
}