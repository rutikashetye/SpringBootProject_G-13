package com.lti.dao;

import java.util.List;

import javax.mail.Address;

import com.lti.entity.Admin;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.entity.User;

public interface AdminDao {

//			approveRetailer(int retailerId) --(onupdate set isApproved to true) [komal]
//			approveProducts(int productId)   [komal]
//			addOrUpdateRetailer(Retailer retailer)   [komal]	
	
	boolean adminLogin(int adminId,String password);
	Admin addAdmin(Admin admin);
	
	public List<Product> is_approvedProducts();
	String approveProduct(int productId);
	String approveRetailer(int retailerId); 
	
	List<Retailer> viewAllRetailer();

	
	
	
	
	
}
