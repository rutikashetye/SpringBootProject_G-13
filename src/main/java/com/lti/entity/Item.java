package com.lti.entity;

import java.time.LocalDate;

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
@Table(name="tbl_item")
public class Item {
	
	@Id
	@SequenceGenerator(name="item_seq",initialValue=3001,allocationSize=1)
	@GeneratedValue(generator="item_seq",strategy=GenerationType.SEQUENCE)
	int itemId;
	
	int quantity;
	boolean isPurchased;
	double totalPrice;
	LocalDate itemPlacedDate;
	
	@ManyToOne
	@JoinColumn(name="cartId")
	Cart cart;
	
	
	@ManyToOne
	@JoinColumn(name="productId")
	Product product;


	public LocalDate getItemPlacedDate() {
		return itemPlacedDate;
	}


	public void setItemPlacedDate(LocalDate itemPlacedDate) {
		this.itemPlacedDate = itemPlacedDate;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public boolean isPurchased() {
		return isPurchased;
	}


	public void setPurchased(boolean isPurchased) {
		this.isPurchased = isPurchased;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@JsonIgnore
	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	@JsonIgnore
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
