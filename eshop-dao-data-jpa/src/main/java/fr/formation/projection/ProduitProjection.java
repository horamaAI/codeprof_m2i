package fr.formation.projection;

import org.springframework.beans.factory.annotation.Value;

public interface ProduitProjection {
	public int getId();
	public String getLibelle();
	
	@Value("#{target.fournisseur.nom}")
	public String getFournisseurNom();
	
	@Value("#{target.fournisseur.id}")
	public int getFournisseurId();
	
	@Value("#{ target.fournisseur.adresse == null ? 'RENNES' : target.fournisseur.adresse.ville }")
	public String getFournisseurVille();
	
	@Value("#{ target.fournisseur.adresse?.rue + ' ' + target.fournisseur.adresse?.codePostal + ' ' + target.fournisseur.adresse?.ville }")
	public String getFournisseurAdresseComplete();
	
	public FournisseurProjection getFournisseur();
}