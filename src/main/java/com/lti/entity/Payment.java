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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbl_payment")
public class Payment {
	
	@Id
	@SequenceGenerator(name="pay_seq",initialValue=2001,allocationSize=1)
	@GeneratedValue(generator="pay_seq",strategy=GenerationType.SEQUENCE)
	int paymentId;
	
	@Enumerated(EnumType.STRING)
	payType paymentType;
	
	@Enumerated(EnumType.STRING)
	orderStatus status;
	
	double amount;
	LocalDate paymentDate;
	
	@ManyToOne
	@JoinColumn(name="cartId")
	Cart cart;

	
	
	
	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public payType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(payType paymentType) {
		this.paymentType = paymentType;
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


	@JsonIgnore
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	

}
