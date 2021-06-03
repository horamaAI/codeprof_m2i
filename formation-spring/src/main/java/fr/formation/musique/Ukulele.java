package fr.formation.musique;

import org.springframework.stereotype.Component;

@Component
public class Ukulele implements IInstrument {
	@Override
	public String toString() {
		return "LINT LINT LINT";
	}
}