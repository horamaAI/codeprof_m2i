package fr.formation.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class PrincipaleServlet extends HttpServlet {
	public int getIntegerParameter(HttpServletRequest req, String parameterName) {
		String idString = req.getParameter(parameterName);
		
		return Integer.parseInt(idString);
	}
	
	public <T> T createService(Class<T> clz) {
		try {
			return clz.getDeclaredConstructor().newInstance();
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void delegate(HttpServletRequest req, HttpServletResponse resp, String viewName) throws ServletException, IOException {
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/" + viewName + ".jsp")
			.forward(req, resp);
	}
}