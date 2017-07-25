package com.stackroute.activitystream.ActivityStreamBackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

import com.stackroute.activitystream.ActivityStreamBackend.dao.UserRegistrationDAOImpl;
import com.stackroute.activitystream.ActivityStreamBackend.model.UserRegistration;

public class UserRegistrationDAOTest 
{
	static AnnotationConfigApplicationContext context;
	static UserRegistrationDAOImpl userRegistrationDAOImpl;
	
	@BeforeClass
	public static void initialize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.stackroute.activitystream.ActivityStreamBackend");
		context.refresh();
		
		userRegistrationDAOImpl=(UserRegistrationDAOImpl)context.getBean("userRegistrationDAO");
	}
	
	@Test
	public void addUserTestCase()
	{
		UserRegistration userRegistration=new UserRegistration();
		userRegistration.setLoginID("harsha");
		userRegistration.setPassword("password@123");
		userRegistration.setEmailID("harsha@gmail.com");
		userRegistration.setUsername("HarshaVardhar");
		userRegistration.setMobile("9991188812");
		
		assertTrue("Object is not Created",userRegistrationDAOImpl.addUser(userRegistration));
	}

	@Test(expected=DataIntegrityViolationException.class)
	public void inValidEmailTestCase()
	{
		UserRegistration userRegistration=new UserRegistration();
		userRegistration.setLoginID("sunita");
		userRegistration.setPassword("password@123");
		userRegistration.setEmailID("sunita.com");
		userRegistration.setUsername("Sunita Kumari");
		userRegistration.setMobile("7888979911");
		
		assertTrue("Object is not Created",userRegistrationDAOImpl.addUser(userRegistration));
	}
	
}
