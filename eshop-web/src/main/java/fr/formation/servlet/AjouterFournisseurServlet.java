package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.model.Fournisseur;
import fr.formation.service.FournisseurService;

@WebServlet("/ajouter-fournisseur")
public class AjouterFournisseurServlet extends HttpServlet {
	//Affichage du formulaire
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/ajouter-fournisseur.jsp")
			.forward(req, resp);
	}
	
	//Traitement du formulaire
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Récupération des paramètres
		String nom = req.getParameter("nom");
		String mail = req.getParameter("mail");
		String siret = req.getParameter("siret");
		String telephone = req.getParameter("telephone");
		
		//Fabrication du fournisseur
		Fournisseur monFournisseur = new Fournisseur();
		
		monFournisseur.setNom(nom);
		monFournisseur.setEmail(mail);
		monFournisseur.setSiret(siret);
		monFournisseur.setTelephone(telephone);

		//Enregistrement du fournisseur
		FournisseurService srvFournisseur = new FournisseurService();
		srvFournisseur.add(monFournisseur);
		
		//Redirection vers la liste des fournisseurs
		resp.sendRedirect("liste-fournisseur");
	}
}