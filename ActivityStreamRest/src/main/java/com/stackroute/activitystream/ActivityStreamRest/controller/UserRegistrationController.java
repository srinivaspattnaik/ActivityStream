package com.stackroute.activitystream.ActivityStreamRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activitystream.ActivityStreamBackend.dao.UserRegistrationDAO;
import com.stackroute.activitystream.ActivityStreamBackend.model.UserRegistration;

@RestController
public class UserRegistrationController 
{

	@Autowired
	UserRegistrationDAO userRegistrationDAO;
	
	@RequestMapping(value="/userRegister",method=RequestMethod.POST)
	public ResponseEntity<UserRegistration> userRegister(@RequestBody UserRegistration userRegistration)
	{
		userRegistrationDAO.addUser(userRegistration);
		return new ResponseEntity<UserRegistration>(userRegistration,HttpStatus.OK);
	}
	
}
