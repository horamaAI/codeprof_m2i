package fr.formation.musique;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy //Demande à SPRING de ne pas instancier de Guitariste tant qu'on le manipule pas
@Scope("prototype")
//@Scope("session") //Scope Session
//@Scope("request") //Scope Request
public class Guitariste implements IMusicien {
//	@Autowired(required = false)
	@Autowired
//	@Qualifier("ukulele")
	private IInstrument instrument;
	
	@Autowired
	private List<IInstrument> instruments;
	
	public Guitariste() {
		System.out.println("CONSTRUCTION D'UN GUITARISTE");
	}
	
	public void jouer() {
		System.out.println(this.instruments.size());
		System.out.println("Le guitariste joue : " + this.instrument);
	}
}