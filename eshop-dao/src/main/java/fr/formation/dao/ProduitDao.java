package fr.formation.dao;

public class ProduitDao {
	public void findById(int id) {
		System.out.println("[bient�t] SELECT * FROM produit WHERE PRO_ID = " + id);
	}
}