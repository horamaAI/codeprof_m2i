package fr.formation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //On active l'annotation pendant l'execution de JAVA
@Target(ElementType.METHOD) //On active que pour les méthodes de classe
public @interface CustomTransactional {

}