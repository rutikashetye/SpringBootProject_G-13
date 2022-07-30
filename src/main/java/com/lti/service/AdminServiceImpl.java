package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;
import com.lti.entity.Admin;
import com.lti.entity.Product;
import com.lti.entity.Retailer;


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

	
	
	public List<Product> is_approvedProducts() {
		return dao.is_approvedProducts();
	}

	public String approveProduct(int productId) {
		return dao.approveProduct(productId);
	}

	
	public String approveRetailer(int retailerId) {
		return dao.approveRetailer(retailerId);
	}
	
	
	
	public List<Retailer>viewAllRetailer() {
	       return dao.viewAllRetailer();
	}

}
