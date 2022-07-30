package com.lti.service;

import java.util.List;

import com.lti.entity.Item;
import com.lti.entity.Product;
import com.lti.entity.Retailer;

public interface RetailerService {
	Item AddOrUpdateProdcutToCart(Item item);
//	Product getProductsbyItemId(int itemId);
	
	public Product getProductByProductId(int productId);
	public Retailer getRetailer(int retailerId);
	public String addProduct(Product product);
	
	public List<Product> viewAllProducts();
	
}
