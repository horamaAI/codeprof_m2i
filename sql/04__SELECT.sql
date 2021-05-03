SELECT * FROM produit;
SELECT PRO_ID FROM produit;
SELECT PRO_ID AS idproduit FROM produit;

SELECT *
FROM produit
WHERE PRO_PRIX > 1000;

-- Sélectionner le client ID 1
SELECT * FROM client WHERE CLI_ID = 1;

-- Sélectionner le produit dont le nom est égal à une valeur ('Combinaison Summer')
SELECT * FROM produit WHERE PRO_LIBELLE = 'Combinaison Summer';

-- Sélectionner les produits contenant « a »
SELECT * FROM produit WHERE PRO_LIBELLE LIKE '%a%';

-- Sélectionner le client ID 1 ET le client ID 2
SELECT * FROM client WHERE CLI_ID = 1 OR CLI_ID = 2;

-- 	Avec AND/OR et IN
SELECT * FROM client WHERE CLI_ID IN (1, 2);


-- inner JOIN
Select A.CLI_NOM As NomDuClient, A.CLI_ADRESSE_MAIL As Email, B.ADR_VILLE
From Client A
	inner join Adresse B ON A.Cli_adresse_id = B.Adr_id

-- Left JOIN
Select A.CLI_NOM As NomDuClient, A.CLI_ADRESSE_MAIL As Email, B.ADR_VILLE
From Client A
	inner join Adresse B ON A.Cli_adresse_id = B.Adr_id
	
-- Left + inner JOIN
Select A.CLI_NOM As NomDuClient, A.CLI_ADRESSE_MAIL As Email, B.ADR_VILLE, Cmd.CMD_ID
From Client A
	inner join Commande Cmd On A.Cli_id = Cmd.Cmd_Client_id
	Left join Adresse B ON Cmd.Cmd_adresse_id = B.Adr_id

	
-- Achats(commande) avec infos de la personne
Select CMD_ID, CMD_DATE,CMD_TOTAL
	, CLI_NOM, CLI_PRENOM
From commande Cmd 
	inner join client Cli On Cli.Cli_id = Cmd.Cmd_Client_id

-- Achats(commande) avec infos produit
Select CMD_ID, CMD_DATE,CMD_TOTAL
	, PRO_LIBELLE
	, ATTR_TYPE, ATTR_VALEUR
From commande Cmd
	inner join commande_detail Cmde On Cmd.Cmd_id = Cmde.Cmde_Commande_id
	inner join Attribut Attr On Attr.Attr_id = Cmde.Cmde_Attribut_id
	inner join Produit Pro On Pro.Pro_id = Attr.Attr_Produit_id
	
-- personnes avec leur achats et infos produit si disponible
Select CLI_NOM, CLI_PRENOM
	, CMD_ID, CMD_DATE,CMD_TOTAL
	, CMDE_QUANTITE, cmde_prix_unitaire
	, PRO_LIBELLE
	, ATTR_VALEUR
From client Cli
	Left join commande Cmd On Cmd.Cmd_Client_id = Cli.Cli_id
	Left join commande_detail Cmde On Cmd.Cmd_id = Cmde.Cmde_Commande_id
	Left join Attribut Attr On Attr.Attr_id = Cmde.Cmde_Attribut_id
	Left join Produit Pro On Pro.Pro_id = Cmde.Cmde_Produit_id

-- personnes avec leur achats sans infos produit 
Select  CLI_NOM, CLI_PRENOM
	, CMD_ID, CMD_DATE,CMD_TOTAL
From client Cli
	inner join commande Cmd On Cmd.Cmd_Client_id = Cli.Cli_id
	
-- requete de non-correspondance selon 2 éthode
	-- avec un liaison sans correspondance
	Select produit.*
	from produit
		left join commande_detail On commande_detail.cmde_produit_id = produit.pro_id
	Where commande_detail.cmde_produit_id Is Null
	-- avec une sous requete
	Select produit.*
	from produit
	Where pro_id not in(
		(Select distinct cmde_produit_id From commande_detail )
		);



-- 2 derniers Achats(commande) avec infos client, produit, fournisseurs
Select CLI_NOM, CLI_PRENOM
	, CMD_ID, CMD_DATE,CMD_TOTAL
	, PRO_LIBELLE
	, ATTR_TYPE, ATTR_VALEUR
From commande Cmd
	inner join client Cli On Cmd.CMD_CLIENT_ID = Cli.Cli_id
	inner join commande_detail Cmde On Cmd.Cmd_id = Cmde.Cmde_Commande_id
	inner join Attribut Attr On Attr.Attr_id = Cmde.Cmde_Attribut_id
	inner join Produit Pro On Pro.Pro_id = Attr.Attr_Produit_id
	inner join Fournisseure Fou On Pro.Pro_Fournisseur_id = Fou.Fou_id
ORder by CMD_DATE desc
Limit 2


-- changer le nom de la personne avec l'id 1
	Update client 
	Set Cli_nom = 'BOURDIN'
	Where Cli_id = 1;

-- augmenter le prix d produit avec l'id 1
	Update produit
	Set Pro_prix= Pro_prix * 1.10
	Where Pro_id = 1;

-- Réduction de 20% des produits non commandés selon 2 méthodes
	-- méthode 1 : avec une liaison sans correspondance
	Update produit
		left join commande_detail On commande_detail.cmde_produit_id = produit.pro_id
	Set Pro_prix = Pro_prix - (Pro_prix * 0.2)
	Where commande_detail.cmde_produit_id Is Null;

	-- méthode 2 : avec une sous requete
	Update produit
	Set Pro_prix = Pro_prix - (Pro_prix * 0.2)
	Where pro_id not in(
		(Select distinct cmde_produit_id  From commande_detail )
		)


-- Supprimer les produit jamais acheté selon 2 méthodes
	-- méthode 1 : avec une liaison sans correspondance
		Delete produit
		from produit
			left join commande_detail On commande_detail.cmde_produit_id = produit.pro_id
		Where commande_detail.cmde_produit_id Is Null;

	-- méthode 2 : avec une sous requete
		Delete from produit
		Where pro_id not in(
							(Select distinct cmde_produit_id  From commande_detail )
							)

-- selectionné les 2 dernieres commandes

	Select distinct CLI_NOM, CLI_PRENOM
		, CMD_ID, CMD_DATE,CMD_TOTAL
		, PRO_LIBELLE
		, ATTR_TYPE, ATTR_VALEUR
	From commande Cmd
		inner join client Cli On Cmd.CMD_CLIENT_ID = Cli.Cli_id
		inner join commande_detail Cmde On Cmd.Cmd_id = Cmde.Cmde_Commande_id
		inner join Attribut Attr On Attr.Attr_id = Cmde.Cmde_Attribut_id
		inner join Produit Pro On Pro.Pro_id = Attr.Attr_Produit_id
		inner join Fournisseur Fou On Pro.Pro_Fournisseur_id = Fou.Fou_id
	ORder by CMD_date desc, CMD_id  desc
	Limit 2;


-- Sélectionner tous les clients et leur CA - Ranger les informations par CA décroissant

	Select  Max(CLI_NOM) As NomClient
	 , Max(CLI_PRENOM) As PrenomClient
		, Sum(cmde_quantite * cmde_prix_unitaire) ChiffreAffaires
	From client Cli 
		left join commande Cmd On Cmd.CMD_CLIENT_ID = Cli.Cli_id
		left join commande_detail Cmde On Cmd.Cmd_id = Cmde.Cmde_Commande_id
	Group By Cli_id
	ORder by Sum(cmde_quantite * cmde_prix_unitaire) Desc


-- Sélectionner tous les clients et leur CA - Ranger les informations par CA décroissant

	Select  CLI_NOM As NomClient
	 , CLI_PRENOM As PrenomClient
	, Sum(cmde_quantite * cmde_prix_unitaire) ChiffreAffaires
	From client Cli 
		left join commande Cmd On Cmd.CMD_CLIENT_ID = Cli.Cli_id
		left join commande_detail Cmde On Cmd.Cmd_id = Cmde.Cmde_Commande_id
	Group By Cli_id , CLI_PRENOM , CLI_NOM
	ORder by Sum(cmde_quantite * cmde_prix_unitaire) Desc






-- Mini boss
-- Sélectionner les clients
--   Le prix minimum d’un produit acheté, et son libellé
--   Le prix maximum d’un produit acheté, et son libellé
--   Son panier moyen
--   Sa première date d’achat
--   Sa dernière date d’achat
SELECT
	CLI_NOM,
	MIN(CMDE_PRIX_UNITAIRE) AS PRIX_MINI,
	(
		SELECT PRO_LIBELLE
		FROM produit p
		INNER JOIN commande_detail cd2 ON cd2.CMDE_PRODUIT_ID = p.PRO_ID
		INNER JOIN commande cmd2 ON cmd2.CMD_ID = cd2.CMDE_COMMANDE_ID
		WHERE cmd2.CMD_CLIENT_ID = cli.CLI_ID
		ORDER BY cd2.CMDE_PRIX_UNITAIRE ASC
		LIMIT 1
	) AS LIBELLE_MINI,
	MAX(CMDE_PRIX_UNITAIRE) AS PRIX_MAXI,
	(
		SELECT PRO_LIBELLE
		FROM produit p
		INNER JOIN commande_detail cd2 ON cd2.CMDE_PRODUIT_ID = p.PRO_ID
		INNER JOIN commande cmd2 ON cmd2.CMD_ID = cd2.CMDE_COMMANDE_ID
		WHERE cmd2.CMD_CLIENT_ID = cli.CLI_ID
		ORDER BY cd2.CMDE_PRIX_UNITAIRE DESC
		LIMIT 1
	) AS LIBELLE_MAXI,
	AVG(CMD_TOTAL) AS PANIER_MOYEN,
	MIN(CMD_DATE) AS PREMIERE_DATE,
	MAX(CMD_DATE) AS DERNIERE_DATE

FROM client cli
INNER JOIN commande cmd ON cmd.CMD_CLIENT_ID = cli.CLI_ID
INNER JOIN commande_detail cd ON cd.CMDE_COMMANDE_ID = cmd.CMD_ID
GROUP BY CLI_NOM;


-- Libellé produit, prix minimum
SELECT PRO_LIBELLE
FROM produit p
INNER JOIN commande_detail cd ON cd.CMDE_PRODUIT_ID = p.PRO_ID
INNER JOIN commande cmd ON cmd.CMD_ID = cd.CMDE_COMMANDE_ID
WHERE cmd.CMD_CLIENT_ID = 1
ORDER BY CMDE_PRIX_UNITAIRE ASC
LIMIT 1;