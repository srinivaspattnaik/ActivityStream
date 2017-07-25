package com.stackroute.activitystream.ActivityStreamBackend;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.activitystream.ActivityStreamBackend.dao.UserRegistrationDAO;
import com.stackroute.activitystream.ActivityStreamBackend.model.UserRegistration;

public class UserRegistrationDAOTest 
{
	static AnnotationConfigApplicationContext context;
	static UserRegistrationDAO userRegistrationDAO;
	private static Validator validator;
	
	@BeforeClass
	public static void initialize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.stackroute.activitystream.ActivityStreamBackend");
		context.refresh();
		
		userRegistrationDAO=(UserRegistrationDAO)context.getBean("userRegistrationDAO");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}
	
	/*@Test
	public void addUserTestCase()
	{
		UserRegistration userRegistration=new UserRegistration();
		
		userRegistration.setLoginID("harsha");
		userRegistration.setPassword("password@123");
		userRegistration.setEmailID("harsha@gmail.com");
		userRegistration.setUsername("HarshaVardhar");
		userRegistration.setMobile("9991188812");
		
		assertTrue("User has not Created",userRegistrationDAO.addUser(userRegistration));
	}

	@Test 	//(expected=ConstraintViolationException.class)
	public void fieldsValidationTestCase()
	{
		UserRegistration userRegistration=new UserRegistration();
		userRegistration.setLoginID("sunita");
		userRegistration.setPassword("password@123");
		userRegistration.setEmailID("sunita@gmail.com");
		userRegistration.setUsername("Sunita Kumari");
		userRegistration.setMobile("7888979911");
		
		Set<ConstraintViolation<UserRegistration>> violations = validator.validate(userRegistration);
		
		assertFalse(violations.isEmpty());
		
		//assertTrue("User has not Created",userRegistrationDAO.addUser(userRegistration));
	}
	
	@Test
	public void deleteUserTestCase()
	{
		assertTrue("Could not be Deleted User May Not Exist",userRegistrationDAO.deleteUser("harsha"));
	}
	
	@Test
	public void updateUserTestCase()
	{
		UserRegistration userRegistration=new UserRegistration();
		userRegistration.setLoginID("sunita");
		userRegistration.setPassword("password123");
		userRegistration.setEmailID("sunita@gmail.com");
		userRegistration.setUsername("Sunita Sangvi");
		userRegistration.setMobile("7888979922");
		
		assertTrue("Could not be Updated",userRegistrationDAO.updateUser(userRegistration));
	}*/
	
	@Test
	public void authenticationValidationTestCase()
	{
		assertEquals("User Name Password Does not Match","Password123",userRegistrationDAO.getUser("fareed123").getPassword());
	}
	
}
