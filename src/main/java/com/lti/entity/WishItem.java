package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbl_wishitem")
public class WishItem {

	@Id
	@SequenceGenerator(name = "wishItem_seq", initialValue = 9001,allocationSize = 1)
	@GeneratedValue(generator = "wishItem_seq",strategy = GenerationType.SEQUENCE)
	int wishItemId;
	
	double quantity;
	
	@ManyToOne
	@JoinColumn(name="wishlistId")
	Wish wishlist;
	
	@ManyToOne
	@JoinColumn(name="productId")
	Product product;

	
	public int getWishItemId() {
		return wishItemId;
	}

	public void setWishItemId(int wishItemId) {
		this.wishItemId = wishItemId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@JsonIgnore
	public Wish getWishlist() {
		return wishlist;
	}

	public void setWishlist(Wish wishlist) {
		this.wishlist = wishlist;
	}

	@JsonIgnore
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
