package com.lti.dto;

import com.lti.entity.Item;
import com.lti.entity.Product;
import com.lti.entity.Retailer;

public class NewViewCartDto {

	Product product;
	Item item;
	Retailer retailer;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Retailer getRetailer() {
		return retailer;
	}
	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}
	
	
}
