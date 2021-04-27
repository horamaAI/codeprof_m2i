package fr.formation.zoo;

import java.lang.reflect.Constructor;
import java.util.HashMap;

public class AdvancedSingleton {
	private static HashMap<Class, Object> instances = new HashMap<>();
	
	public static Object getInstance(Class<?> clz) {
		
		//Principe : on récupère le constructeur du type en paramètre
		//			on l'utilise pour instancier
		
		try {
			if (!instances.containsKey(clz)) {
				Constructor<?> ctor = clz.getDeclaredConstructor();
				
				ctor.setAccessible(true);
				
				Object instance = ctor.newInstance();
				
				instances.put(clz, instance);
			}
			
			return instances.get(clz);
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
}