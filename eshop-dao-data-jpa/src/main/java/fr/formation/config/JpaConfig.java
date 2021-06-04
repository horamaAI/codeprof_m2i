package fr.formation.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement //Permet d'activer les annotations @Transactional
@EnableJpaRepositories("fr.formation.dao") //On active SPRING DATA-JPA pour nos DAO
public class JpaConfig {
	
	@Bean //Création d'un bean DataSource
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/eshop?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setMaxTotal(10);
		
		return dataSource;
	}
	
	@Bean //Création d'un EntityManagerFactory pour SPRING
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		Properties hibernateProperties = new Properties();
		
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("fr.formation.model");
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setJpaProperties(hibernateProperties);

		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		
		return emf;
	}
	
	@Bean //Création d'un bean TransactionManager
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		
		transactionManager.setEntityManagerFactory(emf);
		
		return transactionManager;
	}
}