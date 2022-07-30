package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.RetailerDao;
import com.lti.dto.RegResponseDto;
import com.lti.entity.Item;
import com.lti.entity.Product;
import com.lti.entity.Retailer;

@Service
public class RetailerServiceImpl implements RetailerService {
	@Autowired
	RetailerDao dao;

	@Override
	public Item AddOrUpdateProdcutToCart(Item item) {
		Item obj2 = dao.AddOrUpdateProdcutToCart(item);
		return obj2;

	}

	@Override
	public Retailer getRetailer(int retailerId) {
		return dao.searchRetailerById(retailerId);
	}

	public String addProduct(Product product) {
		try {
			Product new_product = dao.addOrUpdateProduct(product);
			return "Product Added";
		} catch (Exception e) {
			return "Error occurred no product added";
		}
	}

	@Override
	public Product getProductByProductId(int productId) {
		// TODO Auto-generated method stub
		return dao.getProductByProductId(productId);
	}

	public List<Product> viewAllProducts() {
		return dao.viewAllProducts();
	}

//	public RegResponseDto retailerSignup(Retailer retailer) {	//verify data
//		try {
//			Retailer retailer2=dao.addOrUpdateRetailer(retailer);
//			String email=retailer2.getRetailerEmail();
//			String text="Registration Successful.Kindly wait for Admin Approval";
//			String subject="Registration Confirmation";
//			//emailService.sendEmailForSignUp(email, text, subject);
//			//System.out.println("Email sent");
//			RegResponseDto dto=new RegResponseDto();
//			dto.setRetailerId(retailer2.getRetailerId());
//	
//		}
//		
//	}
}
