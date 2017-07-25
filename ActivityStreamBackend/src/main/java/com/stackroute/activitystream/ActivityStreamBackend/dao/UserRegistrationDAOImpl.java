package com.stackroute.activitystream.ActivityStreamBackend.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
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
	
	public UserRegistration getUser(String loginID)
	{
		Session session=sessionFactory.openSession();
		UserRegistration userRegistration=session.get(UserRegistration.class,loginID);
		session.close();
		return userRegistration;
	}
	
	@Transactional
	public boolean deleteUser(String loginID)
	{
		try
		{
		UserRegistration userRegistration=this.getUser(loginID);
		sessionFactory.getCurrentSession().delete(userRegistration);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	
	@Transactional
	public boolean updateUser(UserRegistration userRegistration)
	{
		try
		{
		sessionFactory.getCurrentSession().update(userRegistration);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
}
