package com.lti.dto;



import com.lti.entity.UserAddress;

public class AddAddressDto {
	UserAddress address;
	int userId;
	public UserAddress getAddress() {
		return address;
	}
	public void setAddress(UserAddress address) {
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}
