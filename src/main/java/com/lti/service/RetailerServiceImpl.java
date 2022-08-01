package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.RetailerDao;
import com.lti.dto.AddProductDto;
import com.lti.dto.AddproductResponseDto;
import com.lti.dto.RegResponseDto;
import com.lti.dto.UpdateProductDto;
import com.lti.dto.UpdateRetailerDto;
import com.lti.entity.Item;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.exception.ProductIdmissingException;
import com.lti.exception.ProductNotFoundException;
import com.lti.exception.RetailerIdmissingException;
import com.lti.exception.RetailerNotFoundexception;

@Service
public class RetailerServiceImpl implements RetailerService {
	@Autowired
	RetailerDao dao;

	
	@Autowired
	EmailService emailService;
	

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
	
	
	public RegResponseDto retailerSignup(Retailer retailer) {	//verify data
		try {
			Retailer retailer2=dao.addOrUpdateRetailer(retailer);
			String email=retailer2.getRetailerEmail();
			String text="Registration Successful.Kindly wait for Admin Approval";
			String subject="Registration Confirmation";
			//emailService.sendEmailForSignUp(email, text, subject);
			//System.out.println("Email sent");
			RegResponseDto dto=new RegResponseDto();
			dto.setRetailerId(retailer2.getRetailerId());
			dto.setMessage(text);
			return dto;
//			return "Registration Successful";
			
		}
		catch(Exception e) {
//			return "Unexpected error";'
			RegResponseDto dto=new RegResponseDto();
			dto.setRetailerId(0);
			dto.setMessage("Unexpected error occured.Signup failed.");
			return dto;
			
			
		}
	}
	
	
	
	public boolean retailerLogin(int retailerId,String retailerPassword) {
		boolean val= dao.loginRetailer(retailerId, retailerPassword);
		return val;
	}


	public UpdateRetailerDto updateRetailer(Retailer retailer) {
		UpdateRetailerDto updateRetailer=new UpdateRetailerDto();
		try {
			if(retailer.getRetailerId()==0) {
				throw new RetailerIdmissingException("please mention your retailerId");
			}
			else if(dao.searchRetailerById(retailer.getRetailerId())==null) {
				throw new RetailerNotFoundexception("Retailer not found");
			}else {
			Retailer retailer2=dao.addOrUpdateRetailer(retailer);
//			return "User ID: "+user2.getUserId()+" "+user2.getUserName();
			updateRetailer.setMessage("Updated Successfully");
			updateRetailer.setRetailer(retailer2);
			return updateRetailer;
		}}
		catch(Exception e) {
			updateRetailer.setMessage(e.getMessage());
			return updateRetailer;
		}
		
	}



	@Override
	public List<Retailer> viewAllRetailers() {
		return dao.viewAllRetailer();
	}



	@Override
	public AddproductResponseDto addProduct(AddProductDto product) {
		try {
			Product product2=dao.addOrUpdateProduct(product);
			AddproductResponseDto dto=new AddproductResponseDto();
			String text="Product Added";
			dto.setProductId(product2.getProductId());
			dto.setMessage(text);
			return dto;
			
		}
		catch(Exception e) {
			AddproductResponseDto dto=new AddproductResponseDto();
			dto.setProductId(0);
			dto.setMessage("Unexpected error occured.");
			return dto;
			
			
		}
	}

	@Override
	public UpdateProductDto updateProduct(AddProductDto dtoproduct) {
		UpdateProductDto updateProduct=new UpdateProductDto();
		try {
			if(dtoproduct.getProduct().getProductId()==0) {
				throw new ProductIdmissingException("please mention productId");
			}
			else if(dao.getProductByProductId(dtoproduct.getProduct().getProductId())==null) {
				throw new ProductNotFoundException("Product not found");
			}else {
			Product product2=dao.addOrUpdateProduct(dtoproduct);
			updateProduct.setMessage("Updated Successfully");
			updateProduct.setProduct(product2);
			return updateProduct;
		}}
		catch(Exception e) {
			updateProduct.setMessage(e.getMessage());
			return updateProduct;
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Item AddOrUpdateProdcutToCart(Item item) {
		Item obj2 = dao.AddOrUpdateProdcutToCart(item);
		return obj2;

	}

	@Override
	public Retailer getRetailer(int retailerId) {
		return dao.searchRetailerById(retailerId);
	}

	@Override
	public Product getProductByProductId(int productId) {
		// TODO Auto-generated method stub
		return dao.getProductByProductId(productId);
	}
//not_Approved Products
	public List<Product> viewAllProducts() {
		return dao.viewAllProducts();
	}

	public List<Retailer> viewAllRetailer() {
		return dao.viewAllRetailer();
	}
	
	public List<Product> viewProductBasedOnCategory(String category) {
			return dao.viewProductBasedOnCategory(category);
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
