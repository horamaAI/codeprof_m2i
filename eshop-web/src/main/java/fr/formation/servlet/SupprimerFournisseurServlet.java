package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.service.FournisseurService;

@WebServlet("/supprimer-fournisseur")
public class SupprimerFournisseurServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//On récupère le paramètre identifiant fournisseur
		String fournisseurIdString = req.getParameter("id");
		int fournisseurId = Integer.parseInt(fournisseurIdString);
		FournisseurService srvFournisseur = new FournisseurService();
		
		//On supprime ....
		srvFournisseur.deleteById(fournisseurId);
		
		//On redirige vers la page de liste des fournisseurs
		resp.sendRedirect("liste-fournisseur");
	}
}