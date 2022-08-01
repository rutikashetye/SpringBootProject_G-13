package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class PanPicDto {
	private int retailerId;
	private MultipartFile panPic;
	public int getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}
	public MultipartFile getPanPic() {
		return panPic;
	}
	public void setPanPic(MultipartFile panPic) {
		this.panPic = panPic;
	}
	
	

}
