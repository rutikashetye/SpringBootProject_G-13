package com.lti.dao;

import java.util.List;

import javax.mail.Address;

import com.lti.entity.Admin;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.entity.User;

public interface AdminDao {

//			addOrUpdateRetailer(Retailer retailer)   [komal]	
	
	boolean adminLogin(int adminId,String password);
	Admin addAdmin(Admin admin);
	
	public List<Product> is_approvedProducts();
	String approveProduct(int productId);
	String approveRetailer(int retailerId); 
	
	public List<Retailer> is_approvedRetailer();

	
	
	
	
	
}
