package com.lti.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Cart {
	
	@Id
	@SequenceGenerator(name="cart_seq",initialValue=4001,allocationSize=1)
	@GeneratedValue(generator="cart_seq",strategy=GenerationType.SEQUENCE)
	int cartId;
	
	@OneToOne
	Customer customer;
	
	@OneToMany(mappedBy="cart")
	List<Item>items;
	
	
	@OneToMany(mappedBy="cart")
	List<Order>orders;


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	

}
