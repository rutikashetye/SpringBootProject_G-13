package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminLoginData;
import com.lti.entity.Admin;
import com.lti.service.AdminService;


@RestController
@RequestMapping("/paark")
@CrossOrigin
public class AdminController {

	@Autowired
	AdminService service;
	
	@RequestMapping(value="/add-admin",method=RequestMethod.POST)
	public String signup(@RequestBody Admin admin) {
		String m=service.addAdmin(admin); 
	    return m;
	}
	
	@PostMapping("/admin-login")
	public boolean login(@RequestBody AdminLoginData data )
	{
		boolean isValid = service.adminLogin(data.getadminId(), data.getPassword());
		return isValid;
	}
}
