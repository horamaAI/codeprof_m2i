package fr.formation;

import java.util.ArrayList;

import fr.formation.zoo.Animal;
import fr.formation.zoo.AnimalFactory;
import fr.formation.zoo.Chat;
import fr.formation.zoo.Cheval;
import fr.formation.zoo.Chien;
import fr.formation.zoo.CouleurAnimal;
import fr.formation.zoo.Felide;
import fr.formation.zoo.IChassable;
import fr.formation.zoo.IChasseur;
import fr.formation.zoo.Leopard;
import fr.formation.zoo.Loup;
import fr.formation.zoo.Piege;

public class ApplicationZoo {
	public static void main(String[] args) {
		//Instancier un nouveau Chat
//		Felide albert = new Chat();
//		Felide bernard = new Leopard();
//		
//		albert.dormir();
//		bernard.dormir();
		
		
		
		Animal monAnimal = new Loup();
		monAnimal.manger();
		
		IChasseur chasseur = new Chien();
		IChassable proie = new Cheval();
//		Piege piege = new Piege();
		Piege piege = Piege.getInstance();
		Piege toto = Piege.getInstance();

		System.out.println(piege);
		System.out.println(toto);
		
//		chasseur.chasser(proie);
		chasseur.chasser(piege);
		
		Felide monFelide = AnimalFactory.creerFelide();
		monFelide.dormir();
		
		System.exit(200);
		
		
		
		
		
		
		
		
		
		
		

		ArrayList<Felide> felides = new ArrayList<>();
		
		felides.add(new Chat());
		felides.add(new Leopard());
		
		for (Felide f : felides) {
//			f.dormir();
//			f.courrir();
			System.out.println(f);
			
			f.setCouleur(CouleurAnimal.ROUGE);

			if (f.getCouleur() == CouleurAnimal.ROUGE) {
				System.out.println("COULEUR ROUGE");
			}
			
			else if (f.getCouleur() == CouleurAnimal.BLEUE) {
				System.out.println("COULEUR BLEUE");
			}
			
			if (f.equals(new Chat())) {
				System.out.println("OK !");
			}
			
			if (f instanceof Chat) {
				//Casting : on transforme une variable
				//Casting : on change le type à la manipulation
				Chat chat = (Chat) f;
				chat.griffer();
				
	//			( (Chat) f ).griffer();
			}
		}
		
		
		//Convertir la valeur : parsing
		String valeur = "5";
		int a = Integer.parseInt(valeur);
	}
}