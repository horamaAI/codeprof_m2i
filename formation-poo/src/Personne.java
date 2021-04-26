
public class Personne {
	String nom;
	String prenom = "Albert";
	int age = 18;
	
	boolean isChild() {
		if (this.age < 18) {
			return true;
		}
		
		return false;
	}
}