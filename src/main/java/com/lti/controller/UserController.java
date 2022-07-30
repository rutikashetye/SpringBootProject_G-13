package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.UserLoginData;
import com.lti.entity.User;
import com.lti.service.UserService;


@RestController
@RequestMapping("/paark")
@CrossOrigin
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping(value="/add-user",method=RequestMethod.POST)
	public String addorUpdateUser(@RequestBody User user) {
		String m=service.addorUpdateUser(user); 
	    return m;
	}
	//Tested
	
	/*
	 * @PostMapping("/user-login") public boolean login(@RequestBody UserLoginData
	 * data ) { boolean isValid = service.userLogin(data.getUserEmail(),
	 * data.getPassword()); return isValid; }
	 */
	
	@PostMapping(value = "/user-login")
	public boolean userLogin(@RequestBody UserLoginData data) {
		boolean isValid=service.userLogin(data.getUserId(),data.getPassword());
		return isValid;
	}
}
