package fr.formation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.formation.model.Categorie;

public class CategorieDaoSql extends AbstractDaoSql implements ICategorieDao {
	@Override
	public List<Categorie> findAll() {
		List<Categorie> categories = new ArrayList<>();
		
		ResultSet resultSet = this.getResult("SELECT * FROM categorie");
		
		try {
			while (resultSet.next()) { //Pour chaque catégorie
				//Instanciation
				Categorie categorie = new Categorie();
				
				//Affectation
				categorie.setId(resultSet.getInt("CAT_ID"));
				categorie.setLibelle(resultSet.getString("CAT_LIBELLE"));
				categorie.setDescription(resultSet.getString("CAT_DESCRIPTION"));
				
				//TODO : catégorie parent ?
				
				//Ajout dans la liste
				categories.add(categorie);
			}
		}
		
		catch (SQLException sqle) {
			System.out.println("Problème création catégories.");
		}
		
		return categories;
	}

	@Override
	public Optional<Categorie> findById(int id) {
		ResultSet resultSet = this.getResult("SELECT * FROM categorie WHERE CAT_ID = " + id);
		
		try {
			if (resultSet.next()) { //Si j'ai une catégorie
				//Instanciation
				Categorie categorie = new Categorie();
				
				//Affectation
				categorie.setId(resultSet.getInt("CAT_ID"));
				categorie.setLibelle(resultSet.getString("CAT_LIBELLE"));
				categorie.setDescription(resultSet.getString("CAT_DESCRIPTION"));
				
				//TODO : catégorie parent ?
				
				return Optional.of(categorie);
			}
		}
		
		catch (SQLException sqle) {
			System.out.println("Problème création catégories.");
		}
		
		return Optional.empty();
	}

	@Override
	public Categorie add(Categorie entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie update(Categorie entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}