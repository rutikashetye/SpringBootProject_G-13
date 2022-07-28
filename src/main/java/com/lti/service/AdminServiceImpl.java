package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;
import com.lti.entity.Admin;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao dao;
	
	public boolean adminLogin(int adminId, String password) {
		// TODO Auto-generated method stub
		return dao.adminLogin(adminId, password);
	}
	
	public String addAdmin(Admin admin) {
		try {
		Admin admin2=dao.addAdmin(admin);	
		return "Signup Successful";
		}
		catch(Exception e)
		{
			return"Unexpected errror occured";
		}
	}

}
