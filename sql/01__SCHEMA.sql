-- Création de la base de données
CREATE DATABASE eshop COLLATE utf8_general_ci;

-- Utilisation de la base de données
USE eshop;

-- Vérifier la liste des tables
SHOW TABLES;



-- Table client :
-- id, nom, prénom, adresse email, numéro tél, mot de passe, date de naissance
-- CREATE TABLE eshop.client
-- CREATE TABLE client (
-- 	CLI_ID INT NOT NULL,
-- 	CLI_NOM VARCHAR(50) NOT NULL,
-- 	CLI_PRENOM VARCHAR(50) NOT NULL,
-- 	CLI_ADRESSE_MAIL VARCHAR(150) NOT NULL,
-- 	CLI_TELEPHONE VARCHAR(20),
-- 	CLI_MOT_PASSE VARCHAR(300) NOT NULL,
-- 	CLI_DATE_NAISSANCE DATE
-- ) ENGINE = InnoDb;

-- -- Ajouter une clé primaire
-- ALTER TABLE client
-- 	ADD CONSTRAINT Pk_Client
-- 	PRIMARY KEY (CLI_ID);

-- -- Ajouter l'auto incrément
-- ALTER TABLE client CHANGE CLI_ID CLI_ID INT NOT NULL AUTO_INCREMENT;


-- Table client
DROP TABLE IF EXISTS client;
CREATE TABLE client (
	CLI_ID INT NOT NULL AUTO_INCREMENT,
	CLI_NOM VARCHAR(50) NOT NULL,
	CLI_PRENOM VARCHAR(50) NOT NULL,
	CLI_ADRESSE_MAIL VARCHAR(150) NOT NULL,
	CLI_TELEPHONE VARCHAR(20),
	CLI_MOT_PASSE VARCHAR(300) NOT NULL,
	CLI_DATE_NAISSANCE DATE,
	CLI_ADRESSE_ID INT, -- Clé étrangère vers Adresse
	PRIMARY KEY (CLI_ID)
) ENGINE = InnoDb;


-- Table fournisseur
CREATE TABLE fournisseur (
	FOU_ID INT NOT NULL AUTO_INCREMENT,
	FOU_NOM VARCHAR(50) NOT NULL,
	FOU_TELEPHONE VARCHAR(20),
	FOU_ADRESSE_MAIL VARCHAR(150) NOT NULL,
	FOU_SIRET VARCHAR(20),
	FOU_ADRESSE_ID INT, -- Clé étrangère vers Adresse
	PRIMARY KEY (FOU_ID)
) ENGINE = InnoDb;


-- Table produit
CREATE TABLE produit (
	PRO_ID INT NOT NULL AUTO_INCREMENT,
	PRO_LIBELLE VARCHAR(50) NOT NULL,
	PRO_PRIX DECIMAL(10, 2) NOT NULL DEFAULT 0,
	PRO_STOCK INT NOT NULL DEFAULT 0,
	PRO_IMAGE VARCHAR(255),
	PRO_PRIX_ACHAT DECIMAL(10, 2) NOT NULL DEFAULT 0,
	PRO_DESCRIPTION TEXT,
	PRO_FOURNISSEUR_ID INT NOT NULL, -- Clé étrangère vers Fournisseur
	PRO_CATEGORIE_ID INT NOT NULL, -- Clé étrangère vers Catégorie
	PRIMARY KEY (PRO_ID)
) ENGINE = InnoDb;


-- Table categorie
CREATE TABLE categorie (
	CAT_ID INT NOT NULL AUTO_INCREMENT,
	CAT_LIBELLE VARCHAR(50) NOT NULL,
	CAT_DESCRIPTION TEXT,
	CAT_PARENT_ID INT, -- Clé étrangère vers Catégorie mère
	PRIMARY KEY (CAT_ID)
) ENGINE = InnoDb;


-- Table adresse
CREATE TABLE adresse (
	ADR_ID INT NOT NULL AUTO_INCREMENT,
	ADR_NUMERO_RUE VARCHAR(5) NOT NULL,
	ADR_RUE VARCHAR(50) NOT NULL,
	ADR_LIGNE_2 VARCHAR(100),
	ADR_LIGNE_3 VARCHAR(100),
	ADR_CODE_POSTAL VARCHAR(10) NOT NULL,
	ADR_VILLE VARCHAR(100) NOT NULL,
	ADR_PAYS VARCHAR(50) NOT NULL DEFAULT 'FRANCE',
	PRIMARY KEY (ADR_ID)
) ENGINE = InnoDb;

-- yyyy-mm-dd OU dd/mm/yyyy VOIRE yyyy-dd-mm --- HH:mm:ss.ms
-- Table commande
CREATE TABLE commande (
	CMD_ID INT NOT NULL AUTO_INCREMENT,
	CMD_DATE DATETIME NOT NULL DEFAULT NOW(),
	-- CMD_DATE DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CMD_TOTAL DECIMAL(10, 2) NOT NULL DEFAULT 0,
	CMD_ETAT ENUM('ENCOURS', 'PREPARATION', 'EXPEDIEE', 'LIVREE', 'ANNULEE') NOT NULL DEFAULT 'ENCOURS',
	CMD_CLIENT_ID INT NOT NULL, -- Clé étrangère vers Client
	CMD_ADRESSE_ID INT NOT NULL, -- Clé étrangère vers Adresse
	PRIMARY KEY (CMD_ID)
) ENGINE = InnoDb;



-- Table attribut
CREATE TABLE attribut (
	ATTR_ID INT NOT NULL AUTO_INCREMENT,
	ATTR_TYPE ENUM('COULEUR', 'TAILLE') NOT NULL DEFAULT 'COULEUR',
	ATTR_VALEUR VARCHAR(50) NOT NULL,
	ATTR_PRODUIT_ID INT NOT NULL, -- Clé étrangère vers Produit
	PRIMARY KEY (ATTR_ID)
) ENGINE = InnoDb;



-- Table commande_detail
CREATE TABLE commande_detail (
	CMDE_PRODUIT_ID INT NOT NULL, -- Clé primaire ET clé étrangère vers Produit
	CMDE_COMMANDE_ID INT NOT NULL, -- Clé primaire ET clé étrangère vers Commande
	CMDE_ATTRIBUT_ID INT NOT NULL, -- Clé primaire ET clé étrangère vers Attribut
	CMDE_QUANTITE INT NOT NULL DEFAULT 1,
	CMDE_PRIX_UNITAIRE DECIMAL(10, 2) NOT NULL DEFAULT 0,
	PRIMARY KEY (CMDE_PRODUIT_ID, CMDE_COMMANDE_ID, CMDE_ATTRIBUT_ID)
) ENGINE = InnoDb;





-- Type de données
-- INT : entier
-- CHAR(n) : chaine avec n caractères (précis)
-- VARCHAR(n) : chaine avec n caractères maxi
-- DATE / DATETIME : date / dateheure
-- TIMESTAMP : dateheure (date mini = 01/01/1970 --> nombre de ms qui nous sépare de maintenant jusqu'au 01/01/1970)
-- TEXT (limitation de 8000 caractères maxi)
-- LONGTEXT (encore plus long : 4Go)
-- ENUM ( ENUM('OPT1', 'OPT2', etc.) )
-- BIT / BOOL / BOOLEAN
-- DECIMAL(m, n) (nombre chiffres maxi, nombre chiffre après virgule)
	-- 9999,99 : DECIMAL(6, 2)

-- Options sur les colonnes / champs
-- NOT NULL : valeur null non autorisée
-- DEFAULT valeur : valeur par défaut

-- NOT NULL DEFAULT 0 : autorise pas le null, et par défaut, ce sera la valeur 0

-- Options clé primaire / clé étrangère / index / auto_incrément
-- PRIMARY KEY : clé primaire
-- FOREIGN KEY : clé étrangère
-- INDEX : créer un index
-- AUTO_INCREMENT : auto incrément (mysql)
-- IDENTITY : auto incrément (sql server)