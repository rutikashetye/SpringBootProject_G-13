package com.lti.dto;

import com.lti.entity.Retailer;

public class UpdateRetailerDto {
	String message;
	Retailer retailer;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Retailer getRetailer() {
		return retailer;
	}
	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}
	
	

}
