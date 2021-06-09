package fr.formation.projection;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import fr.formation.model.CommandeEtat;

public interface CommandeProjection {
	public int getId();
	public LocalDateTime getDate();
	
	@Value("#{ target.client.nom + ' ' + target.client.prenom }")
	public String getClientNom();
	
	public CommandeEtat getEtat();
	public List<CommandeDetailProjection> getDetails();
}