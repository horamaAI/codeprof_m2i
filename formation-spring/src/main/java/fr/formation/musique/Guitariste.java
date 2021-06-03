package fr.formation.musique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Guitariste implements IMusicien {
//	@Autowired(required = false)
	@Autowired
	@Qualifier("guitare")
	private IInstrument instrument;

	public IInstrument getInstrument() {
		return instrument;
	}

	public void setInstrument(IInstrument instrument) {
		this.instrument = instrument;
	}
	
	public Guitariste() {
		System.out.println("CONSTRUCTION D'UN GUITARISTE");
	}
	
	public void jouer() {
		System.out.println("Le guitariste joue : " + this.instrument);
	}
}