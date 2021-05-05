package fr.formation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationUncheckedException {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer a = null;
		
		while (a == null) {
			System.out.println("Saisir un entier : ");
			
			try {
				a = sc.nextInt();
				System.out.println("L'entier est : " + a);
			}
			
			catch (StringIndexOutOfBoundsException sioobe) {
				System.out.println("Normalement on passe pas ici ...");
	//			ime.printStackTrace(); //Pour réimprimer le message d'erreur
			}
			
			catch (InputMismatchException ime) {
				System.out.println("Ceci n'est pas un entier ...");
				sc.nextLine(); //On écrit ça pour "vider" le flux (la touche Entrée reste dans le flux sinon)
			}
			
			catch (Exception e) { //On passera pas ici car InputMismatchException est déjà "catchée"
				System.out.println("Ceci n'est pas un entier (2) ... et on ne passera pas ici ...");
				sc.nextLine(); //On écrit ça pour "vider" le flux (la touche Entrée reste dans le flux sinon)
			}
		}
		
		System.out.println("Fin du programme ..");
		
		sc.close();
	}
}