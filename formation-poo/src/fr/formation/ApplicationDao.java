package fr.formation;

import fr.formation.dao.DaoFactory;
import fr.formation.dao.IChienDAO;
import fr.formation.zoo.Chien;

public class ApplicationDao {
	public static void main(String[] args) {
		IChienDAO chienDao = DaoFactory.creerChienDao();
		
		chienDao.findAll();
		chienDao.findById(5);
		chienDao.save(new Chien());
	}
}