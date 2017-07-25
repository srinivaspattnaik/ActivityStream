package com.stackroute.activitystream.ActivityStreamBackend.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.activitystream.ActivityStreamBackend.model.UserRegistration;

@Repository("userRegistrationDAO")
public class UserRegistrationDAOImpl implements UserRegistrationDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public UserRegistrationDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean addUser(UserRegistration userRegistration)
	{
		try
		{
		sessionFactory.getCurrentSession().save(userRegistration);
		return true;
		}
		catch(Exception e)
		{
		return false;	
		}
	}
	
	@Transactional
	public boolean deleteUser(String loginID)
	{
		UserRegistration userRegistration=sessionFactory.openSession().get(UserRegistration.class,loginID);
		
		return true;
	}
}
