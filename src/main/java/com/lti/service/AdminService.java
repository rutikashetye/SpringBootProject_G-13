package com.lti.service;


import java.util.List;

import com.lti.entity.Admin;
import com.lti.entity.Product;
import com.lti.entity.Retailer;


public interface AdminService {
	boolean adminLogin(int adminId, String password);
	String addAdmin(Admin admin);
	public List<Product> is_approvedProducts() ;
	public String approveProduct(int productId);
	public String approveRetailer(int retailerId);
	public List<Retailer> viewAllRetailer();
}
