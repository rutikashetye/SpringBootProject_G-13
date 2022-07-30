package com.lti.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_cart")
public class Cart {
	
	@Id
	@SequenceGenerator(name="cart_seq",initialValue=4001,allocationSize=1)
	@GeneratedValue(generator="cart_seq",strategy=GenerationType.SEQUENCE)
	int cartId;
	
	@OneToOne
	@JoinColumn(name="userId")
	User user;
	
	@OneToMany(mappedBy="cart")
	List<Item>items;
	
	
	@OneToMany(mappedBy="cart")
	List<Payment>payments;


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}


	public List<Payment> getOrders() {
		return payments;
	}


	public void setOrders(List<Payment> payments) {
		this.payments = payments;
	}
	
	

}
