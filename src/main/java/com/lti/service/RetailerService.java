package com.lti.service;

import java.util.List;

import com.lti.dto.AddProductDto;
import com.lti.dto.AddproductResponseDto;
import com.lti.dto.RegResponseDto;
import com.lti.dto.UpdateProductDto;
import com.lti.dto.UpdateRetailerDto;
import com.lti.entity.Item;
import com.lti.entity.Product;
import com.lti.entity.Retailer;

public interface RetailerService {
	Item AddOrUpdateProdcutToCart(Item item);
//	Product getProductsbyItemId(int itemId);
	
	public Product getProductByProductId(int productId);
	public Retailer getRetailer(int retailerId);
	public List<Retailer> viewAllRetailer();
	public List<Product> viewAllProducts();
	public List<Product> viewProductBasedOnCategory(String category);
	public UpdateRetailerDto updateRetailer(Retailer retailer);
	public List<Retailer> viewAllRetailers();
	public AddproductResponseDto addProduct(AddProductDto product);
	public UpdateProductDto updateProduct(AddProductDto dtoproduct);
	public RegResponseDto retailerSignup(Retailer retailer);
	boolean retailerLogin(int retailerId,String retailerPassword);
	
	public List<Product> viewAllProductsById(int retailerId);
	
}
