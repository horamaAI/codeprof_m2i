-- Contrainte client vers adresse
ALTER TABLE client
	ADD CONSTRAINT FK_ClientAdresse
	FOREIGN KEY (CLI_ADRESSE_ID)
	REFERENCES adresse (ADR_ID)
	-- ON DELETE CASCADE - En supprimant l'adresse, on supprimera le client
	-- ON UPDATE CASCADE - En modifiant l'id de l'adresse, on modifiera l'id de l'adresse du client
	;

SHOW CREATE TABLE client;

-- Contrainte fournisseur vers adresse
ALTER TABLE fournisseur
	ADD CONSTRAINT FK_FournisseurAdresse
	FOREIGN KEY (FOU_ADRESSE_ID)
	REFERENCES adresse (ADR_ID);

-- Contrainte catégorie vers catégorie mère
ALTER TABLE categorie
	ADD CONSTRAINT FK_CategorieCategorieParent
	FOREIGN KEY (CAT_PARENT_ID)
	REFERENCES categorie (CAT_ID);


-- Contraintes produit vers fournisseur, et produit vers catégorie
ALTER TABLE produit
	ADD CONSTRAINT FK_ProduitFournisseur
	FOREIGN KEY (PRO_FOURNISSEUR_ID)
	REFERENCES fournisseur (FOU_ID)
	,
	ADD CONSTRAINT FK_ProduitCategorie
	FOREIGN KEY (PRO_CATEGORIE_ID)
	REFERENCES categorie (CAT_ID);


-- Contraintes commande_detail vers produit, commande_detail vers commande, et commande_detail vers attribut
ALTER TABLE commande_detail
	ADD CONSTRAINT FK_CommandeDetailProduit
	FOREIGN KEY (CMDE_PRODUIT_ID)
	REFERENCES produit (PRO_ID)
	,
	ADD CONSTRAINT FK_CommandeDetailCommande
	FOREIGN KEY (CMDE_COMMANDE_ID)
	REFERENCES commande (CMD_ID)
	ON DELETE CASCADE
	,
	ADD CONSTRAINT FK_CommandeDetailAttribut
	FOREIGN KEY (CMDE_ATTRIBUT_ID)
	REFERENCES attribut (ATTR_ID);


-- Contrainte attribut vers produit
ALTER TABLE attribut
	ADD CONSTRAINT FK_AttributProduit
	FOREIGN KEY (ATTR_PRODUIT_ID)
	REFERENCES produit (PRO_ID)
	ON DELETE CASCADE
	ON UPDATE CASCADE;


-- Contraintes commande vers client, et commande vers adresse
ALTER TABLE commande
	ADD CONSTRAINT FK_CommandeClient
	FOREIGN KEY (CMD_CLIENT_ID)
	REFERENCES client (CLI_ID)
	,
	ADD CONSTRAINT FK_CommandeAdresse
	FOREIGN KEY (CMD_ADRESSE_ID)
	REFERENCES adresse (ADR_ID);