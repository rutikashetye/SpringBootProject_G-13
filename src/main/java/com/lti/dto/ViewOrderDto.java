package com.lti.dto;

import java.time.LocalDate;

import com.lti.entity.Payment;
import com.lti.entity.Product;

public class ViewOrderDto {
	double amount;
	Product product;
	String productName;
	int productId;
	int quantity;
	String productImage;
	LocalDate vieworderDate;
	
	public LocalDate getVieworderDate() {
		return vieworderDate;
	}
	public void setVieworderDate(LocalDate vieworderDate) {
		this.vieworderDate = vieworderDate;
	}
	Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
	
	
	
	
	

}
