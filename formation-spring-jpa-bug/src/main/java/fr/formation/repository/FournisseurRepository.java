package fr.formation.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.formation.dao.IFournisseurDao;
import fr.formation.model.Fournisseur;

@Repository
public class FournisseurRepository implements IFournisseurDao {
	private EntityManager em;
	
	@Override
	public List<Fournisseur> findAll() {
		List<Fournisseur> fournisseurs = em
				.createQuery("select f from fournisseur f", Fournisseur.class)
				.getResultList();
		
		return fournisseurs;
	}

	@Override
	public Fournisseur findById(int id) {
//		return em.find(Fournisseur.class, id);
		
		return em
				.createQuery("select f from Fournisseur f where f.id = ?1", Fournisseur.class)
				.setParameter(1, id)
				.getSingleResult();
	}

	@Override
	public Fournisseur add(Fournisseur entity) {
		em.persist(entity); //Sauvegarde (INSERT)
		
		return entity;
	}

	@Override
	public Fournisseur save(Fournisseur entity) {
		if (entity.getId() > 0) {
			entity = em.merge(entity); //Sauvegarde (UPDATE)
		}
		
		else {
			em.persist(entity); //Sauvegarde (INSERT)
		}

		return entity;
	}

	@Override
	@Transactional
	public boolean deleteById(int id) {
		//OPTION #1
//		Fournisseur fournisseur = this.findById(id);
		
		//OPTION #2
//		Fournisseur fournisseur = new Fournisseur();
//		fournisseur.setId(id);
		
		try {
			//OPTIONS #1 & #2
//			em.remove(em.merge(fournisseur)); //On attache le fournisseur puis on le supprime
			
			//OPTION #3
			em	.createQuery("delete from Fournisseur f where f.id = ?1")
				.setParameter(1, id)
				.executeUpdate();
			
			return true;
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public int count() {
		return em
				.createQuery("select count(f) from Fournisseur f", Long.class)
				.getSingleResult()
				.intValue();
	}

	@Override
	public List<Fournisseur> findAllFetchingProduits() {
		List<Fournisseur> fournisseurs = em
				.createQuery("select distinct f from Fournisseur f left join fetch f.produits p", Fournisseur.class)
				.getResultList();
		
		return fournisseurs;
	}
}