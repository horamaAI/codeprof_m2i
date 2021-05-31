package fr.formation.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener //Possibilité de mapper dans web.xml avec balise <listener>
public class RequestListener implements ServletRequestListener {
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		//Dans sre, on va trouver dans la requête et toutes les info (paramètres, attributs, etc.)
		
		System.out.println("Requête HTTP reçue !");
	}
}