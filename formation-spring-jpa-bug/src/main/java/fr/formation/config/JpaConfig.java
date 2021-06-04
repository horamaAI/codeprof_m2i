package fr.formation.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class JpaConfig {
	//DATASOURCE
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		//Configuration de la source de données
		dataSource.setDriverClassName("com.mysql.jbdc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/eshop?serverTimezone=UTC");
		dataSource.setUsername("rot");
		dataSource.setPassword("");
		dataSource.setMaxTotal(10);
		
		return dataSource;
	}
	
	//ENTITYMANAGERFACTORY
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		Properties properties = new Properties();
		
		//Configuration de l'EntityManagerFactory
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("com.cgi.model");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		
		//Préparation des properties Hibernate
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		properties.setProperty("hibernate.show_sql", "true");
		
		//On donne ces properties à EntityManagerFactory
		emf.setJpaProperties(properties);
		
		return emf;
	}
	
	//TRANSACTIONMANAGER
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		
		//Configuration du gestionnaire de transaction
		transactionManager.setEntityManagerFactory(emf);
		
		return transactionManager;
	}
	
	//PAS OBLIGATOIRE MAIS PRATIQUE POUR TRANDUIRE LES EXCEPTIONS DE TYPE HIBERNATEEXCEPTION EN DATAACCESSEXCEPTION
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}