package fr.formation.dao;

public class DAOFactory {
	public static IProduitDao createProduitDao() {
		return new ProduitDaoSql();
	}
	
	public static ICategorieDao createCategoryDao() {
		return new CategorieDaoSql();
	}
	
	public static IFournisseurDao createFournisseurDao() {
		return new FournisseurDaoSql();
	}
}