package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	//Affichage du formulaire de connexion
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/login.jsp")
			.forward(req, resp);
	}
	
	
	//Traitement de la connexion
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String myUsername = req.getParameter("username");
		String myPassword = req.getParameter("password");

//		System.out.println(myUsername);
//		System.out.println(myPassword);
		
		//Vérifier le login & password
		if (myUsername.equals("toto") && myPassword.equals("titi")) {
			//Enregistrer le username dans la session utilisateur
			req.getSession().setAttribute("sessionUser", myUsername);
			
			//Rediriger vers /home
			resp.sendRedirect("home");
		}
		
		else {
			//Rediriger vers /login
			resp.sendRedirect("login");
		}
	}
}