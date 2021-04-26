import java.util.Scanner;

public class ApplicationPrincipale {
	public static void main(String[] args) {
//		exo1();
//		fizzBuzz();
		inverse();
	}
	
	
	static void exo1() {
		//Déclaration variables
		String prenom;
		String message;
		
		// Demande du prénom
		prenom = demander("Quel est votre prénom ?");
		
		// Construction du message
		message = concatener("Bonjour ", prenom);
		
		// Affichage du message
		afficher(message);
	}
	
	
	static void fizzBuzz() {
		//Déclaration des variables
		int compteur;
		String message;
		
		
		for (compteur = 1; compteur <= 100; compteur++) {
			// Vider le message
			message = "";
			
			// Multiple de 3
			if (modulo(compteur, 3) == 0) {
				message = "Fizz";
			}
			
			// Multiple de 5
			if (modulo(compteur, 5) == 0) {
				message = concatener(message, "Buzz");
			}
			
			// Aucun multiple
//			if (message == "") {
			if (message.equals("")) {
				//Conversion int en String
				message = "" + compteur;
			}
			
			// Afficher message
			afficher(message);
			
			// Saut de ligne après chaque nombre finissant par un 9 ( 9, 19, 29, ... 99 )
			if (modulo(compteur, 10) == 9) {
				afficher("");
			}
		}
	}
	
	static int modulo(int a, int modulo) {
		return a % modulo;
	}
	
	
	
	static void inverse() {
		//Déclaration des variables
		//final pour Constante
		final String MESSAGEUTILISATEUR = demander("Chaine à inverser ?"); // Demander à l'utilisateur
		String messageInverse;
		char[] tableauCaracteres = MESSAGEUTILISATEUR.toCharArray(); //On récupère un tableau de caractères
		
		
		// Inversion de la chaine
		messageInverse = "";
		
		//Solution #1 : boucle POUR
		for (int i = 0; i < tableauCaracteres.length; i++) {
			messageInverse = concatener("" + tableauCaracteres[i], messageInverse);
		}
		
		//Solution #2 : boucle POURCHAQUE
		for (char c : tableauCaracteres) {
			messageInverse = concatener("" + c, messageInverse);
		}
		
		//Solution #3 : boucle POUR
		for (int i = 0; i < MESSAGEUTILISATEUR.length(); i++) {
			char c = MESSAGEUTILISATEUR.charAt(i);
			messageInverse = concatener("" + c, messageInverse);
		}
		
		//Solution #4 : StringBuilder (cheating)
		StringBuilder sb = new StringBuilder(MESSAGEUTILISATEUR);
		messageInverse = sb.reverse().toString();

		// Affichage
		afficher(messageInverse);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	static String demander(String message) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(message);
		
		String result = sc.nextLine();
		
		return result;
	}
	
	static String concatener(String a, String b) {
		return a + b;
	}
	
	static void afficher(String message) {
		System.out.println(message);
	}
}