
public class ApplicationDemoObjet {
	public static void main(String[] args) {
//		String[] noms = new String[10];
//		String[] prenoms = new String[10];
//		int[] ages = new int[10];
//		
//		for (int i = 0; i < 10; i++) {
//			System.out.println(noms[i] + " " + prenoms[i] + " " + ages[i] + " ans.");
//		}
		
//		Personne[] personnes = new Personne[] {
//			new Personne(), new Personne()
//		};
//		
//		for (int i = 0; i < 2; i++) {
//			System.out.println(personnes[i].nom + " " + personnes[i].prenom + " " + personnes[i].age + " ans.");
//			
//			System.out.println(isChild(personnes[i]));
//			System.out.println( personnes[i].isChild() );
//		}
		
		Personne maPersonne = new Personne(); //@12
		System.out.println(maPersonne.prenom); //@12
//		maPersonne.prenom = "Jérémy";
		demoReference(maPersonne);
		System.out.println(maPersonne.prenom); //@12
		
		maPersonne.isChild();
		
		System.out.println("-----");

		int b = 5;
		if (true) {
			b = 6;
		}
		
		System.out.println(b);
		int a = 2;
		System.out.println(a);
		a = demoValeur(a);
		System.out.println(a);
	}
	
	
	static void demoReference(Personne pers /* @12 */) {
		pers = new Personne(); //@21
		pers.prenom = "Eric"; //@21
	}
	
	static int demoValeur(int a) {
		a = 5;
		return a;
	}
	
	static boolean isChild(Personne pers) {
		if (pers.age < 18) {
			return true;
		}
		
		return false;

//		return (pers.age < 18);
//		return (pers.age < 18) ? true : false;
	}
}