package fr.formation.dao;

public class DAOFactory {
	public static IProduitDao createProduitDao() {
		return new ProduitDaoSql();
	}
}