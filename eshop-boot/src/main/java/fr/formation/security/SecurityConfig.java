package fr.formation.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override //CONFIGURATION DES ACCES
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/assets/**").permitAll()
			.antMatchers("/**").authenticated()
			.and()
			
//			.httpBasic(); //Authentification Basic (utile pour Angular, Vue, etc. par exemple)
			
			.formLogin()
				.loginPage("/page-login") //GET de formulaire de connexion
				.loginProcessingUrl("/perform_login") //POST géré par SPRING SECURITY
				.defaultSuccessUrl("/produit/liste", true) //Redirection OK
				.failureUrl("/page-login?erreur=true") //Redirection KO
				.permitAll() //On autorise tout le monde
				
				
//			.and().csrf().disable() //Désactiver la protection CSRF
			;
	}
	
	@Override //CONFIGURATION DES USERS
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user").password("{noop}123456").roles("USER");
	}
}