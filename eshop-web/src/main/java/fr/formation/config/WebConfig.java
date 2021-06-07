package fr.formation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("fr.formation")
@EnableWebMvc //On active la délégation des requêtes (Dispatcher vers nos contrôleurs)
public class WebConfig implements WebMvcConfigurer {
	@Bean //Configuration du ViewResolver pour le chargement des vues
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}

	
	//CONFIGURATION DES RESSOURCES STATIQUES (css, images, js, etc.)
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
			.addResourceHandler("/assets/**") //Mapping URL web
//			.addResourceHandler("/**/*.*") //Autre exemple : Mapping URL web
			.addResourceLocations("/assets/"); //Répertoire dans lequel se trouvent les ressources
	}
}