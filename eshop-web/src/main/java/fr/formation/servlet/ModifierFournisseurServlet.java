package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Fournisseur;
import fr.formation.service.FournisseurService;

@WebServlet("/modifier-fournisseur")
public class ModifierFournisseurServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//On récupère le paramètre identifiant fournisseur
		String fournisseurIdString = req.getParameter("id");
		int fournisseurId = Integer.parseInt(fournisseurIdString);
		FournisseurService srvFournisseur = new FournisseurService();
		
		//Récupérer le fournisseur
		Fournisseur fournisseur = srvFournisseur.findById(fournisseurId);
		
		//Envoyer dans le scope le fournisseur
		req.setAttribute("fournisseur", fournisseur);
		
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/modifier-fournisseur.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//On récupère le paramètre identifiant fournisseur
		String fournisseurIdString = req.getParameter("id");
		int fournisseurId = Integer.parseInt(fournisseurIdString);
		
		//Récupération des paramètres
		String nom = req.getParameter("nom");
		String mail = req.getParameter("mail");
		String siret = req.getParameter("siret");
		String telephone = req.getParameter("telephone");
		
		FournisseurService srvFournisseur = new FournisseurService();
		
		//Récupère le fournisseur depuis la db
		Fournisseur monFournisseur = srvFournisseur.findById(fournisseurId);
		
		//Réaffecter les nouvelles informations
		monFournisseur.setNom(nom);
		monFournisseur.setEmail(mail);
		monFournisseur.setSiret(siret);
		monFournisseur.setTelephone(telephone);

		//Sauvegarder
		srvFournisseur.update(monFournisseur);
		
		//On redirige vers la liste des fournisseurs (avec message de confirmation, solution #2)
		resp.sendRedirect("liste-fournisseur?fournisseurModifie=true");
	}
}