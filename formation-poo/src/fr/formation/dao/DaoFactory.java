package fr.formation.dao;

public class DaoFactory {
	public static IChienDAO creerChienDao() {
		return new ChienDaoFichier();
	}
	
	public static ILoupDAO creerLoupDao() {
		return new LoupDaoFichier();
	}
}