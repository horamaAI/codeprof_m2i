package fr.formation.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		//Les param?tres de requ?te SONT ET SERONT TOUJOURS des String
		String myUsername = req.getParameter("user");
//		String myIdStr = req.getParameter("id");
//		int id = Integer.parseInt(myIdStr);
		String mySessionUserme = (String)req.getSession().getAttribute("sessionUser");
		List<String> prenoms = new ArrayList<String>();
		
		//Quelques pr?noms
		prenoms.add("J?r?my");
		prenoms.add("Eric");
		prenoms.add("Anh");
		
//		if (mySessionUserme == null) { //Pas connect? !
//			resp.sendRedirect("login");
//			return; //Arr?ter la m?thode ? ce niveau
//		}
		
		//Utilisation du scope Request
		req.setAttribute("utilisateur", myUsername);
		req.setAttribute("prenoms", prenoms);
		
		//DELEGATION DE REQUETE
		this
			.getServletContext() // -> r?cup?rer le contexte de Servlet
			.getRequestDispatcher("/WEB-INF/home.jsp") // -> r?cup?rer le dispacher
			.forward(req, resp); // -> transfert de la requ?te et r?ponse HTTP
		
		
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