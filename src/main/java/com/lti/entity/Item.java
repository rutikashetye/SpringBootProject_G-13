package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	
	@Id
	@SequenceGenerator(name="item_seq",initialValue=3001,allocationSize=1)
	@GeneratedValue(generator="item_seq",strategy=GenerationType.SEQUENCE)
	int itemId;
	
	int quantity;
	
	@ManyToOne
	@JoinColumn(name="cartId")
	Cart cart;
	
	
	@ManyToOne
	@JoinColumn(name="productId")
	Product product;


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


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
