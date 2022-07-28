package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class User {
	
	@Id
	@SequenceGenerator(name="user_seq",initialValue=101,allocationSize=1)
	@GeneratedValue(generator="user_seq",strategy=GenerationType.SEQUENCE)
	int userId;
	
	String userName;
	String userEmail;
	String password;
	String phoneNo;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	List<UserAddress> userAddresses;
	
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	Cart cart;
	
	@OneToOne(mappedBy="user")
	Wish wishlist;

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getuserEmail() {
		return userEmail;
	}

	public void setuserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<UserAddress> getuserAddresses() {
		return userAddresses;
	}

	public void setuserAddresses(List<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Wish getWishlist() {
		return wishlist;
	}

	public void setWishlist(Wish wishlist) {
		this.wishlist = wishlist;
	}
	
	
	

}
