package fr.formation.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class PrincipaleServlet extends HttpServlet {
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.req = req;
		this.resp = resp;
		
		super.service(req, resp);
	}
	
	public int getIntegerParameter(String parameterName) {
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
	
	public void delegate(String viewName) throws ServletException, IOException {
		this.getServletContext()
			.getRequestDispatcher("/WEB-INF/" + viewName + ".jsp")
			.forward(req, resp);
	}
}