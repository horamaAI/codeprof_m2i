package fr.formation.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomTransactionAspect {
	@Before("@annotation(fr.formation.annotation.CustomTransactional)")
	public void beforeTransaction() {
		System.out.println("Démarrage de la transaction");
	}

//	@After("@annotation(fr.formation.annotation.CustomTransactional)")
//	public void afterTransaction() {
//		System.out.println("Fermeture de la transaction");
//	}
	
	@AfterReturning("@annotation(fr.formation.annotation.CustomTransactional)")
	public void afterOkTransaction() {
		System.out.println("Commit de la transaction");
	}
	
	@AfterThrowing("@annotation(fr.formation.annotation.CustomTransactional)")
	public void afterErrorTransaction() {
		System.out.println("Rollback de la transaction");
	}
}