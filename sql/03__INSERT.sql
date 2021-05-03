-- Quelques clients
INSERT INTO client (CLI_NOM, CLI_PRENOM, CLI_ADRESSE_MAIL, CLI_MOT_PASSE, CLI_DATE_NAISSANCE)
	VALUES
	('PERROUAULT', 'Jérémy', 'jeremy.perrouault@ascadis.fr', '123456', '1987-11-02'),
	('DUPONT', 'Albert', 'a.d@gmail.com', '123', '1991-12-25');

SELECT * FROM client;

-- Quelques fournisseurs
INSERT INTO fournisseur (FOU_NOM, FOU_ADRESSE_MAIL, FOU_SIRET)
	VALUES
	('AMAZON', 'amazon@gmail.com', '123456789123');

-- Quelques catégories
INSERT INTO categorie (CAT_LIBELLE, CAT_PARENT_ID)
	VALUES
	('Parachute', NULL),
	('Combinaison', NULL),
	('Combinaison été', 2),
	('Combinaison hivers', 2);

-- Quelques adresses
INSERT INTO adresse (ADR_NUMERO_RUE, ADR_RUE, ADR_CODE_POSTAL, ADR_VILLE)
	VALUES
	('23', 'Rue de la Soif', '06000', 'NICE');


-- Quelques produits
INSERT INTO produit (PRO_LIBELLE, PRO_PRIX, PRO_STOCK, PRO_PRIX_ACHAT, PRO_FOURNISSEUR_ID, PRO_CATEGORIE_ID)
	VALUES
	('Parachute de France', 7999.90, 3, 4000, 1, 1),
	('Combinaison Summer', 435, 30, 125, 1, 3),
	('Combinaison Winter', 200, 5, 155, 1, 4);


INSERT INTO produit (PRO_LIBELLE, PRO_PRIX, PRO_STOCK, PRO_PRIX_ACHAT, PRO_FOURNISSEUR_ID, PRO_CATEGORIE_ID)
	VALUES
	('Altimètre', 50, 3, 20, 1, 1);


-- Quelques attributs
INSERT INTO attribut (ATTR_TYPE, ATTR_VALEUR, ATTR_PRODUIT_ID)
	VALUES
	('COULEUR', 'BLEU', 3);


-- Quelques commandes
INSERT INTO commande (CMD_TOTAL, CMD_CLIENT_ID, CMD_ADRESSE_ID)
	VALUES
	(400, 1, 1);

INSERT INTO commande (CMD_TOTAL, CMD_CLIENT_ID, CMD_ADRESSE_ID)
	VALUES
	(600, 1, 1),
	(4900, 1, 1);


-- Quelques commande_details
INSERT INTO commande_detail (CMDE_PRODUIT_ID, CMDE_COMMANDE_ID, CMDE_ATTRIBUT_ID, CMDE_QUANTITE, CMDE_PRIX_UNITAIRE)
	VALUES
	(3, 1, 1, 2, 200);

INSERT INTO commande_detail (CMDE_PRODUIT_ID, CMDE_COMMANDE_ID, CMDE_ATTRIBUT_ID, CMDE_QUANTITE, CMDE_PRIX_UNITAIRE)
	VALUES
	(2, 2, 1, 1, 600),
	(1, 3, 1, 1, 4900);



-- Quelques commandes pour supprimer / réinitialiser une table
-- DELETE FROM produit;
-- ALTER TABLE produit AUTO_INCREMENT = 1;

-- SET FOREIGN_KEY_CHECKS = 0; -- Désactiver les contraintes de clés étrangères
-- TRUNCATE TABLE produit; -- Attention avec ça, parce qu'il est pas copain les clés étrangères
-- SET FOREIGN_KEY_CHECKS = 1; -- Réactiver les contraintes de clés étrangères