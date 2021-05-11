-- MySQL dump 10.13  Distrib 5.7.17, for Win32 (AMD64)
--
-- Host: localhost    Database: eshop
-- ------------------------------------------------------
-- Server version	5.5.5-10.3.10-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adresse`
--

DROP TABLE IF EXISTS `adresse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adresse` (
  `ADR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ADR_NUMERO_RUE` varchar(5) NOT NULL,
  `ADR_RUE` varchar(50) NOT NULL,
  `ADR_LIGNE_2` varchar(100) DEFAULT NULL,
  `ADR_LIGNE_3` varchar(100) DEFAULT NULL,
  `ADR_CODE_POSTAL` varchar(10) NOT NULL,
  `ADR_VILLE` varchar(100) NOT NULL,
  `ADR_PAYS` varchar(50) NOT NULL DEFAULT 'FRANCE',
  PRIMARY KEY (`ADR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adresse`
--

LOCK TABLES `adresse` WRITE;
/*!40000 ALTER TABLE `adresse` DISABLE KEYS */;
INSERT INTO `adresse` VALUES (1,'23','Rue de la Soif',NULL,NULL,'06000','NICE','FRANCE');
/*!40000 ALTER TABLE `adresse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attribut`
--

DROP TABLE IF EXISTS `attribut`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attribut` (
  `ATTR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ATTR_TYPE` enum('COULEUR','TAILLE') NOT NULL DEFAULT 'COULEUR',
  `ATTR_VALEUR` varchar(50) NOT NULL,
  `ATTR_PRODUIT_ID` int(11) NOT NULL,
  PRIMARY KEY (`ATTR_ID`),
  KEY `FK_AttributProduit` (`ATTR_PRODUIT_ID`),
  CONSTRAINT `FK_AttributProduit` FOREIGN KEY (`ATTR_PRODUIT_ID`) REFERENCES `produit` (`PRO_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attribut`
--

LOCK TABLES `attribut` WRITE;
/*!40000 ALTER TABLE `attribut` DISABLE KEYS */;
INSERT INTO `attribut` VALUES (1,'COULEUR','BLEU',3);
/*!40000 ALTER TABLE `attribut` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorie` (
  `CAT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CAT_LIBELLE` varchar(50) NOT NULL,
  `CAT_DESCRIPTION` text DEFAULT NULL,
  `CAT_PARENT_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`CAT_ID`),
  KEY `FK_CategorieCategorieParent` (`CAT_PARENT_ID`),
  CONSTRAINT `FK_CategorieCategorieParent` FOREIGN KEY (`CAT_PARENT_ID`) REFERENCES `categorie` (`CAT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
INSERT INTO `categorie` VALUES (1,'Parachute',NULL,NULL),(2,'Combinaison',NULL,NULL),(3,'Combinaison été',NULL,2),(4,'Combinaison hivers',NULL,2),(5,'CATEGORIE FROM HIBERNATE',NULL,NULL),(6,'CATEGORIE FROM HIBERNATE 2',NULL,NULL),(7,'CATEGORIE FROM HIBERNATE 3',NULL,NULL),(8,'CATEGORIE FROM HIBERNATE 4',NULL,NULL);
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `CLI_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CLI_NOM` varchar(50) NOT NULL,
  `CLI_PRENOM` varchar(50) NOT NULL,
  `CLI_ADRESSE_MAIL` varchar(150) NOT NULL,
  `CLI_TELEPHONE` varchar(20) DEFAULT NULL,
  `CLI_MOT_PASSE` varchar(300) NOT NULL,
  `CLI_DATE_NAISSANCE` date DEFAULT NULL,
  `CLI_ADRESSE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`CLI_ID`),
  KEY `FK_ClientAdresse` (`CLI_ADRESSE_ID`),
  CONSTRAINT `FK_ClientAdresse` FOREIGN KEY (`CLI_ADRESSE_ID`) REFERENCES `adresse` (`ADR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'PERROUAULT','Jérémy','jeremy.perrouault@ascadis.fr',NULL,'123456','1987-11-02',NULL),(2,'DUPONT','Albert','a.d@gmail.com',NULL,'123','1991-12-25',NULL);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commande` (
  `CMD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CMD_DATE` datetime NOT NULL DEFAULT current_timestamp(),
  `CMD_TOTAL` decimal(10,2) NOT NULL DEFAULT 0.00,
  `CMD_ETAT` enum('ENCOURS','PREPARATION','EXPEDIEE','LIVREE','ANNULEE') NOT NULL DEFAULT 'ENCOURS',
  `CMD_CLIENT_ID` int(11) NOT NULL,
  `CMD_ADRESSE_ID` int(11) NOT NULL,
  PRIMARY KEY (`CMD_ID`),
  KEY `FK_CommandeClient` (`CMD_CLIENT_ID`),
  KEY `FK_CommandeAdresse` (`CMD_ADRESSE_ID`),
  CONSTRAINT `FK_CommandeAdresse` FOREIGN KEY (`CMD_ADRESSE_ID`) REFERENCES `adresse` (`ADR_ID`),
  CONSTRAINT `FK_CommandeClient` FOREIGN KEY (`CMD_CLIENT_ID`) REFERENCES `client` (`CLI_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande`
--

LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
INSERT INTO `commande` VALUES (1,'2021-04-29 16:04:09',400.00,'ENCOURS',1,1),(2,'2021-05-03 09:37:16',600.00,'ENCOURS',1,1),(3,'2021-05-03 09:37:16',4900.00,'ENCOURS',1,1);
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commande_detail`
--

DROP TABLE IF EXISTS `commande_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commande_detail` (
  `CMDE_PRODUIT_ID` int(11) NOT NULL,
  `CMDE_COMMANDE_ID` int(11) NOT NULL,
  `CMDE_ATTRIBUT_ID` int(11) NOT NULL,
  `CMDE_QUANTITE` int(11) NOT NULL DEFAULT 1,
  `CMDE_PRIX_UNITAIRE` decimal(10,2) NOT NULL DEFAULT 0.00,
  PRIMARY KEY (`CMDE_PRODUIT_ID`,`CMDE_COMMANDE_ID`,`CMDE_ATTRIBUT_ID`),
  KEY `FK_CommandeDetailCommande` (`CMDE_COMMANDE_ID`),
  KEY `FK_CommandeDetailAttribut` (`CMDE_ATTRIBUT_ID`),
  CONSTRAINT `FK_CommandeDetailAttribut` FOREIGN KEY (`CMDE_ATTRIBUT_ID`) REFERENCES `attribut` (`ATTR_ID`),
  CONSTRAINT `FK_CommandeDetailCommande` FOREIGN KEY (`CMDE_COMMANDE_ID`) REFERENCES `commande` (`CMD_ID`) ON DELETE CASCADE,
  CONSTRAINT `FK_CommandeDetailProduit` FOREIGN KEY (`CMDE_PRODUIT_ID`) REFERENCES `produit` (`PRO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commande_detail`
--

LOCK TABLES `commande_detail` WRITE;
/*!40000 ALTER TABLE `commande_detail` DISABLE KEYS */;
INSERT INTO `commande_detail` VALUES (1,3,1,1,4900.00),(2,2,1,1,600.00),(3,1,1,2,200.00);
/*!40000 ALTER TABLE `commande_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fournisseur`
--

DROP TABLE IF EXISTS `fournisseur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fournisseur` (
  `FOU_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FOU_NOM` varchar(50) NOT NULL,
  `FOU_TELEPHONE` varchar(20) DEFAULT NULL,
  `FOU_ADRESSE_MAIL` varchar(150) NOT NULL,
  `FOU_SIRET` varchar(20) DEFAULT NULL,
  `FOU_ADRESSE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`FOU_ID`),
  KEY `FK_FournisseurAdresse` (`FOU_ADRESSE_ID`),
  CONSTRAINT `FK_FournisseurAdresse` FOREIGN KEY (`FOU_ADRESSE_ID`) REFERENCES `adresse` (`ADR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fournisseur`
--

LOCK TABLES `fournisseur` WRITE;
/*!40000 ALTER TABLE `fournisseur` DISABLE KEYS */;
INSERT INTO `fournisseur` VALUES (1,'AMAZON',NULL,'amazon@gmail.com','123456789123',NULL),(2,'C-Discount',NULL,'futureadresse@gmail.com',NULL,NULL);
/*!40000 ALTER TABLE `fournisseur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitation`
--

DROP TABLE IF EXISTS `habitation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `habitation` (
  `HAB_CLIENT_ID` int(11) NOT NULL,
  `HAB_ADRESSE_ID` int(11) NOT NULL,
  KEY `FKgk3u5red5ycrg44813rrtdllu` (`HAB_ADRESSE_ID`),
  KEY `FK41cj5o7qqg00o3iu1l691esq4` (`HAB_CLIENT_ID`),
  CONSTRAINT `FK41cj5o7qqg00o3iu1l691esq4` FOREIGN KEY (`HAB_CLIENT_ID`) REFERENCES `client` (`CLI_ID`),
  CONSTRAINT `FKgk3u5red5ycrg44813rrtdllu` FOREIGN KEY (`HAB_ADRESSE_ID`) REFERENCES `adresse` (`ADR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitation`
--

LOCK TABLES `habitation` WRITE;
/*!40000 ALTER TABLE `habitation` DISABLE KEYS */;
/*!40000 ALTER TABLE `habitation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produit` (
  `PRO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRO_LIBELLE` varchar(50) NOT NULL,
  `PRO_PRIX` decimal(10,2) NOT NULL DEFAULT 0.00,
  `PRO_STOCK` int(11) NOT NULL DEFAULT 0,
  `PRO_IMAGE` varchar(255) DEFAULT NULL,
  `PRO_PRIX_ACHAT` decimal(10,2) NOT NULL DEFAULT 0.00,
  `PRO_DESCRIPTION` text DEFAULT NULL,
  `PRO_FOURNISSEUR_ID` int(11) NOT NULL,
  `PRO_CATEGORIE_ID` int(11) NOT NULL,
  PRIMARY KEY (`PRO_ID`),
  KEY `FK_ProduitFournisseur` (`PRO_FOURNISSEUR_ID`),
  KEY `FK_ProduitCategorie` (`PRO_CATEGORIE_ID`),
  CONSTRAINT `FK_ProduitCategorie` FOREIGN KEY (`PRO_CATEGORIE_ID`) REFERENCES `categorie` (`CAT_ID`),
  CONSTRAINT `FK_ProduitFournisseur` FOREIGN KEY (`PRO_FOURNISSEUR_ID`) REFERENCES `fournisseur` (`FOU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit`
--

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
INSERT INTO `produit` VALUES (1,'PRODUIT EDITE DEPUIS JAVA',20.00,0,NULL,10.00,NULL,1,1),(2,'Combinaison Summer',435.00,30,NULL,125.00,NULL,1,3),(3,'Combinaison Winter',200.00,5,NULL,155.00,NULL,1,4),(4,'Altimètre',50.00,3,NULL,20.00,NULL,1,1),(5,'FROM JAVA (v1)',100.00,4,NULL,50.00,NULL,1,1),(6,'FROM JAVA (v2)',100.00,4,NULL,50.00,NULL,1,1);
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-11  9:51:06
