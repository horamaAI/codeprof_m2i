package fr.formation;

import java.util.InputMismatchException;
import java.util.Scanner;

import fr.formation.exception.ChiffreFormatException;
import fr.formation.exception.ChiffreNegatifException;

public class LireChiffreApplication {
	public static void main(String[] args) {
		try {
			int a = lire();
			System.out.println("La saisie est : " + a);
		}
		
		//Gestion des cas d'exceptions
		catch (ChiffreFormatException cfe) {
			System.out.println("Ceci n'est pas un chiffre ...");
		}
		
		catch (ChiffreNegatifException cne) {
			System.out.println("Le chiffre ne peut pas être négatif ...");
		}
		
//		catch (Exception ex) {
//			if (ex.getMessage().equals("format")) {
//				//...
//			}
//			
//			else if (ex.getMessage().equals("negatif")) {
//				//...
//			}
//		}
	}
	
	public static int lire() {
		//Scanner
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Saisir un chiffre : ");
		
		try {
			int a = sc.nextInt();
			
			//Condition < 0
			if (a < 0) {
				throw new ChiffreNegatifException();
			}
			
			//Retour du chiffre saisi
			return a;
		}
		
		//Gestion de l'exception inputmismatch
		catch (InputMismatchException ime) {
			throw new ChiffreFormatException();
		}
	}
}