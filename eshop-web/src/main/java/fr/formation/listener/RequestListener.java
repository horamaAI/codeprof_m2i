package fr.formation.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener //Possibilit� de mapper dans web.xml avec balise <listener>
public class RequestListener implements ServletRequestListener {
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		//Dans sre, on va trouver dans la requ�te et toutes les info (param�tres, attributs, etc.)
		
		System.out.println("Requ�te HTTP re�ue !");
	}
}