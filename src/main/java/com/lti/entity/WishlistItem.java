package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class WishlistItem {

	@Id
	@SequenceGenerator(name="wishlistItem_seq",initialValue=9001,allocationSize=1)
	@GeneratedValue(generator="wishlistItem_seq",strategy=GenerationType.SEQUENCE)
	int wishitemId;
	
	int quantity;
	
	@ManyToOne
	Wishlist wishlist;
	
	
	@ManyToOne
	Product product;


	public int getWishitemId() {
		return wishitemId;
	}


	public void setWishitemId(int wishitemId) {
		this.wishitemId = wishitemId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Wishlist getWishlist() {
		return wishlist;
	}


	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

}
