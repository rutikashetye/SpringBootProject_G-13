package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Order {
	
	@Id
	@SequenceGenerator(name="order_seq",initialValue=2001,allocationSize=1)
	@GeneratedValue(generator="order_seq",strategy=GenerationType.SEQUENCE)
	int orderId;
	
	@Enumerated(EnumType.STRING)
	payType payment;
	
	@Enumerated(EnumType.STRING)
	orderStatus status;
	
	double amount;
	LocalDate date;
	
	@ManyToOne
	@JoinColumn(name="cartId")
	Cart cart;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public payType getPayment() {
		return payment;
	}

	public void setPayment(payType payment) {
		this.payment = payment;
	}

	public orderStatus getStatus() {
		return status;
	}

	public void setStatus(orderStatus status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	

}
