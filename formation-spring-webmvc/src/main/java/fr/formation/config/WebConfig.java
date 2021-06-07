package fr.formation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("fr.formation") //ON SCAN ICI JUSQU'A REIMPLEMENTER ESHOP (et son AppConfig)
@EnableWebMvc //On active la délégation des requêtes (Dispatcher vers nos contrôleurs)
public class WebConfig {

}