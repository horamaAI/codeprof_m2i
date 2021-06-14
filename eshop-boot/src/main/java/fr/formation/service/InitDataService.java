package fr.formation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.formation.dao.IUtilisateurDao;
import fr.formation.model.Utilisateur;

// Implémentation de CommandLineRunner pour que SPRING BOOT exécute run() au démarrage

//@Service
public class InitDataService implements CommandLineRunner {
	@Autowired
	private IUtilisateurDao daoUtilisateur;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		Utilisateur admin = new Utilisateur();
		Utilisateur user = new Utilisateur();
		
		admin.setUsername("admin");
		admin.setPassword(this.passwordEncoder.encode("123456"));
		admin.setAdmin(true);
		
		user.setUsername("user");
		user.setPassword(this.passwordEncoder.encode("123456"));

		this.daoUtilisateur.save(admin);
		this.daoUtilisateur.save(user);
	}
}