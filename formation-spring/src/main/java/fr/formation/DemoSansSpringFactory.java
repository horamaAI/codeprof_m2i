package fr.formation;

import fr.formation.controller.ProduitController;
import fr.formation.dao.IDAOProduit;
import fr.formation.dao.ProduitDaoRepository;
import fr.formation.service.ProduitService;

public class DemoSansSpringFactory {
	public static ProduitController controller() {
		ProduitController ctrl = new ProduitController();
		
		ctrl.setSrvProduit(service());
		
		return ctrl;
	}
	
	public static ProduitService service() {
		ProduitService srv = new ProduitService();

		srv.setDaoProduit(repo());
		
		return srv;
	}
	
	public static IDAOProduit repo() {
		ProduitDaoRepository repo = new ProduitDaoRepository();
		
		return repo;
	}
}