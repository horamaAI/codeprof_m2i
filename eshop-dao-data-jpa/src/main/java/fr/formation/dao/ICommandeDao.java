package fr.formation.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Commande;
import fr.formation.projection.CommandeProjection;

public interface ICommandeDao extends JpaRepository<Commande, Integer> {
	//> Chercher les commandes pour une date entre A et B
	public List<CommandeProjection> findAllByDateBetween(LocalDateTime start, LocalDateTime end);
	public List<Commande> findAllByDateGreaterThanEqualAndDateLessThanEqual(LocalDateTime start, LocalDateTime end);
	public List<Commande> findAllByDateAfterAndDateBefore(LocalDateTime start, LocalDateTime end);
	
	@Query("select c from Commande c where c.date >= ?1 and c.date <= ?2")
	public List<Commande> findAllByDateQuery(LocalDateTime start, LocalDateTime end);
	
	@Query("select c from Commande c left join fetch c.details d where c.date >= ?1 and c.date <= ?2")
	public List<CommandeProjection> findAllByDateBetweenFetching(LocalDateTime start, LocalDateTime end);
	
	
	//> Chercher les commandes dont le prix est > N
	public List<Commande> findAllByTotalGreaterThan(BigDecimal total);
	
	@Query("select c from Commande c where c.total > ?1")
	public List<Commande> findAllByTotalQuery(BigDecimal total);
	
	//> Chercher les commandes dont le prix unitaire d'un détail > N
	public List<Commande> findAllByDetailsPrixUnitaireGreaterThan(BigDecimal prixUnitaire);
	
	@Query("select c from Commande c inner join c.details d where d.prixUnitaire > ?1")
	public List<Commande> findAllByDetailsQuery(BigDecimal prixUnitaire);
	
	
	//> Chercher les commandes du client ID
	public List<Commande> findAllByClientId(int id);
	
	@Query("select c from Commande c where c.client.id = ?1")
	public List<Commande> findAllByClientIdQuery(int id);
	
	@Query(value = "SELECT c.* FROM commande c WHERE c.CMD_CLIENT_ID = ?1", nativeQuery = true)
	public List<Commande> findAllByClientIdNativeQuery(int id);
}