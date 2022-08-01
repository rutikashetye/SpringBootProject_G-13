package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class AadharPicDto {
	private int retailerId;
	private MultipartFile aadharPic;
	public int getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}
	public MultipartFile getAadharPic() {
		return aadharPic;
	}
	public void setAadharPic(MultipartFile aadharPic) {
		this.aadharPic = aadharPic;
	}
	
	
	
	
	




}
