package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class UserAddress {

	@Id
	@SequenceGenerator(name = "address_seq", initialValue = 7001, allocationSize = 1)
	@GeneratedValue(generator = "address_seq", strategy = GenerationType.SEQUENCE)
	int addressId;

	int houseNo;
	String building;
	String city;
	String state;
	String pincode;
	String Country;

	@ManyToOne
	User user;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public User getCustomer() {
		return user;
	}

	public void setCustomer(User user) {
		this.user = user;
	}
	
	

}
