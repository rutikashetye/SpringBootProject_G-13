package com.lti.service;


import com.lti.entity.Admin;


public interface AdminService {
	boolean adminLogin(int adminId, String password);
	String addAdmin(Admin admin);
}
