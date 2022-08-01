package com.lti.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductPicDto {
	private int productId;
	private MultipartFile productPic;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public MultipartFile getProductPic() {
		return productPic;
	}
	public void setProductPic(MultipartFile productPic) {
		this.productPic = productPic;
	}
	
	

}
