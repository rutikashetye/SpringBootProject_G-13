package com.lti.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.lti.entity.Category;
import com.lti.entity.Product;
import com.lti.entity.Retailer;

public class AddProductDto {
	int retailerId;
	Product product;
	
	public int getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}