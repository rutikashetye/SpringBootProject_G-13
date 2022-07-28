package com.lti.dao;

import com.lti.entity.Admin;

public interface AdminDao {

//	addOrupdateAdmin(Admin admin)   [komal]
//			approveRetailer(int retailerId) --(onupdate set isApproved to true) [komal]
//			approveProducts(int productId)   [komal]
//			addOrUpdateRetailer(Retailer retailer)   [komal]	
	
	boolean adminLogin(int adminId,String password);
	Admin addAdmin(Admin admin);
}
