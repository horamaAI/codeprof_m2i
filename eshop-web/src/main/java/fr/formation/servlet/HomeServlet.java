package fr.formation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/home", loadOnStartup = 1)
public class HomeServlet extends HttpServlet {
	public HomeServlet() {
		System.out.println("CREATION");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Les paramètres de requête SONT ET SERONT TOUJOURS des String
		String myUsername = req.getParameter("user");
//		String myIdStr = req.getParameter("id");
//		int id = Integer.parseInt(myIdStr);
		
		//Utilisation du scope Request
		req.setAttribute("utilisateur", myUsername);
		
		//DELEGATION DE REQUETE
		this
			.getServletContext() // -> récupérer le contexte de Servlet
			.getRequestDispatcher("/WEB-INF/home.jsp") // -> récupérer le dispacher
			.forward(req, resp); // -> transfert de la requête et réponse HTTP
		
		
//		resp.setContentType("text/html");
////		resp.getWriter().append("Hello le monde !");
//		resp.getWriter().println("<html>");
//		resp.getWriter().println("<head>");
//		resp.getWriter().println("</head>");
//		resp.getWriter().println("<body>");
//		resp.getWriter().println("Hello " + myUsername);
//		resp.getWriter().println("</body>");
//		resp.getWriter().println("</html>");
	}
}