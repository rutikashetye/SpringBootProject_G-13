package com.lti.service;

import com.lti.entity.User;

public interface UserService {

	boolean userLogin(int userId, String password);
	String addorUpdateUser(User user);
}
