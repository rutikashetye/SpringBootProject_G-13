package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.RegResponseDto;
import com.lti.entity.Item;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.entity.User;
import com.lti.service.RetailerService;


@RestController
@RequestMapping("/paark")
@CrossOrigin
public class RetailerController {

	@Autowired
	RetailerService service;
	
	@RequestMapping(value="/addcart",method=RequestMethod.POST)
	public Item addproductTocart(@RequestBody Item item) {
		Item item2=service.AddOrUpdateProdcutToCart(item); 
	    return item2;
	}
	
	@PostMapping("/viewProductById")
	public Product searchProduct(@RequestBody int productId)
	{
		return service.getProductByProductId(productId);
	}
	
	
	@GetMapping(value="/retailer/{retailerId}")
	public Retailer searchRetailer(@PathVariable int retailerId) {
		return service.getRetailer(retailerId);
	}
	
	@RequestMapping(value="/add-product",method=RequestMethod.POST)
	public String addProduct(@RequestBody Product product) {
		String m=service.addProduct(product); 
	    return m;
	}
	
	@GetMapping("/viewAllProducts")
	public List<Product> viewAllProducts() {
            return service.viewAllProducts();
        }
	
//	
//	@RequestMapping(value="/retailerSignup",method=RequestMethod.POST)
//	public RegResponseDto signup(@RequestBody Retailer retailer) {
//		RegResponseDto regResponseDto=service.retailerSignup(retailer);
//		return regResponseDto;
//		
//		
//	}
	
//	@PostMapping("/retailerLogin")
//	public boolean login(@RequestBody RetailerLoginDto loginData) {
//		boolean isValid=retailerService.retailerLogin(loginData.getRetailerId(),loginData.getRetailerPassword());
//				return isValid;
//	}
	
	
}
