package fr.formation.dao;

public class DAOFactory {
	public static IProduitDao createProduitDao() {
		return new ProduitDaoHibernate();
	}
	
	public static ICategorieDao createCategoryDao() {
		return new CategorieDaoHibernate();
	}
	
	public static IFournisseurDao createFournisseurDao() {
		return new FournisseurDaoHibernate();
	}
	
	public static IAttributDao createAttributDao() {
		return new AttributDaoHibernate();
	}
}