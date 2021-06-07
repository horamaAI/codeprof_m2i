package fr.formation.utilisateur;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
//@Scope("session")
@SessionScope // Il y aura une instance de ce composant SPRING par session utilisateur
public class UserSession {
	private boolean connected;
	private String username;

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}