package com.stackroute.activitystream.ActivityStreamBackend.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.stackroute.activitystream.ActivityStreamBackend.dao.UserRegistrationDAO;
import com.stackroute.activitystream.ActivityStreamBackend.dao.UserRegistrationDAOImpl;
import com.stackroute.activitystream.ActivityStreamBackend.model.UserRegistration;

@Configuration
@EnableTransactionManagement
public class DBConfig 
{
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		//Hibernate related properties
		Properties hibernateprop=new Properties();
		hibernateprop.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateprop.put("hibernate.show_sql", "true"); //optional
		hibernateprop.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
		//Adding the Database related Properties
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/activitystream");
		dataSource.setUsername("root");
		dataSource.setPassword("Password@123");
		
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(hibernateprop);
		sessionBuilder.addAnnotatedClass(UserRegistration.class);
		SessionFactory sessionfactory=sessionBuilder.buildSessionFactory();
		
		System.out.println("Session Factory Object Created");
		
		return sessionfactory;
		
	}
	
	@Bean(name="userRegistrationDAO")
	public UserRegistrationDAO getBlogDAO(SessionFactory sessionFactory)
	{
		System.out.println("UserRegistrationDAO Object Created");
		return new UserRegistrationDAOImpl(sessionFactory);
	}
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Transaction Manager Object Created");
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
