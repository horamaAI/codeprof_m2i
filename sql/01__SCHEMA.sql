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
DROP TABLE IF EXISTS client;
CREATE TABLE client (
	CLI_ID INT NOT NULL AUTO_INCREMENT,
	CLI_NOM VARCHAR(50) NOT NULL,
	CLI_PRENOM VARCHAR(50) NOT NULL,
	CLI_ADRESSE_MAIL VARCHAR(150) NOT NULL,
	CLI_TELEPHONE VARCHAR(20),
	CLI_MOT_PASSE VARCHAR(300) NOT NULL,
	CLI_DATE_NAISSANCE DATE,
	PRIMARY KEY (CLI_ID)
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