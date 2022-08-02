package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminLoginData;
import com.lti.entity.Admin;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.service.AdminService;
//http://localhost/9090/paark/add-admin

@RestController
@RequestMapping("/paark")
@CrossOrigin(origins = "*")
public class AdminController {

	@Autowired
	AdminService service;
	
	@DeleteMapping(value="/rejectProduct/{productId}")
	public String removeItemFromCart(@PathVariable int productId) {
		String message=service.removeProduct(productId);
		return message;
		
	}
	
	@DeleteMapping(value="/rejectRetailer/{retailerId}")
	public String removeRetailer(@PathVariable int retailerId) {
		String message=service.removeRetailer(retailerId);
		return "";
		
	}
	
	
	@RequestMapping(value="/add-admin",method=RequestMethod.POST)
	public String signup(@RequestBody Admin admin) {
		String m=service.addAdmin(admin); 
	    return m;
	}
	//Tested
	
	@PostMapping("/admin-login")
	public boolean login(@RequestBody AdminLoginData data )
	{
		boolean isValid = service.adminLogin(data.getadminId(), data.getPassword());
		return isValid;
	}
	//Tested
	
	
	@GetMapping("/viewApprovedproducts")
	public List<Product> is_approvedProducts() {
		return service.is_approvedProducts();
	}

	@PostMapping("/approveproduct/{productId}")
	public String approveProduct(@PathVariable int productId) {
		return service.approveProduct(productId);
	}

	
	@PostMapping("/approveretailer/{retailerId}")
	public String approveRetailer(@PathVariable int retailerId) {
		return service.approveRetailer(retailerId);
	}
	
	@GetMapping("/viewretailers")
	public List<Retailer> is_approvedRetailer() {
		return service.is_approvedRetailer();
	}
	

	
	
	
	
	
}
