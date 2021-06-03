package fr.formation.musique;

public class Guitariste implements IMusicien {
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