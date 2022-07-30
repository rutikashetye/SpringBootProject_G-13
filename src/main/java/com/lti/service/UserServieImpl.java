package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.UserDao;
import com.lti.entity.User;

@Service
public class UserServieImpl implements UserService {

	@Autowired
	UserDao dao;
	
	public boolean userLogin(int userId, String password) {
		return dao.userLogin(userId, password);
	}
	
	public String addorUpdateUser(User user) {
		try {
		User user2=dao.addorUpdateUser(user);	
		return "Signup Successful";
		}
		catch(Exception e)
		{
			return"Unexpected errror occured";
		}
	}
}
