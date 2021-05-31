package fr.formation.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/*")
@WebFilter({ "/home", "/liste-fournisseur" })
public class SecuriteFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		//V�rifier si on est connect� (exemple dans HomeServlet)
		//Si on est connect�, on va vers la Servlet
		//Si on est pas connect�
		// > Soit on est d�j� sur la page de login, on va vers la Servlet
		// >>> req.getRequestURL().toString() -> donne le nom de l'URL
		// > Soit on est pas sur la page de login, on redirige vers login
		
		System.out.println("FILTER !");
//		response.getWriter().println("Hello world from Filter");
		
		if (req.getSession().getAttribute("sessionUser") == null) { // On est pas connect�
			//On redirige sur la page de login si on y est pas d�j�
			if (!req.getRequestURI().toString().equals("/eshop-web/login")) {
				resp.sendRedirect("login");
				return; //On s'arr�te ici pour pas d�clencher le doFilter
			}
		}
		
		//On appelle la Servlet avec cette instruction
		chain.doFilter(request, response);
	}
}