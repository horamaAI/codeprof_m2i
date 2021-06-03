package fr.formation.musique;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //On rend ce bean prioritaire sur les autres du même type
public class Guitare implements IInstrument {
	@Override
	public String toString() {
		return "GLINK GLINK GLINK";
	}
}