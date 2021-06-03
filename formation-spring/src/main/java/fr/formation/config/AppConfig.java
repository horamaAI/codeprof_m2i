package fr.formation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.formation.Application;

@Configuration //Classe de configuration
@ComponentScan("fr.formation") //Scan du package fr.formation (et sous-packages)
//@ComponentScan({ "fr.formation.package1", "fr.formation.package2" }) //Scan des packages
public class AppConfig {
	//Eventuellement ici des déclarations @Bean ...
	
	@Bean
	public Application app() {
		return new Application();
	}
}