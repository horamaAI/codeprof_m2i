package fr.formation;

import fr.formation.exception.ChiffreNegatifException;

public class ApplicationCheckedException {
	public static void main(String[] args) {
//		try {
//			demoCheckedException();
//		}
//		
//		catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			demoUncheckedException(false);
		}
		
		catch (ChiffreNegatifException cne) {
			System.out.println("Exception de type chiffre négatif ...");
		}
		
		catch (Exception ex) {
			System.out.println("Autre nature d'exception ...");
		}
	}
	
	
	public static void demoCheckedException() throws Exception { //Throws => déléguer la gestion de l'exception au niveau sup.
		//Déclencher manuellement une Checked Exception
		Exception ex = new Exception();
		
		throw ex;
	}
	
	
	public static void demoUncheckedException(boolean chiffre) {
		//Déclencher manuellement une Unchecked Exception
		if (chiffre) {
			throw new ChiffreNegatifException();
		}
		
		throw new RuntimeException();
	}
}