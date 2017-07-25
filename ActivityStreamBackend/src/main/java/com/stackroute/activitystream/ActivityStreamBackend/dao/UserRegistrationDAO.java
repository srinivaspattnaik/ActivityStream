package com.stackroute.activitystream.ActivityStreamBackend.dao;

import com.stackroute.activitystream.ActivityStreamBackend.model.UserRegistration;

public interface UserRegistrationDAO 
{
	public boolean addUser(UserRegistration userRegistration);
	public boolean deleteUser(String loginID);
	public boolean updateUser(UserRegistration userRegistration);
	public UserRegistration getUser(String loginID);
}
