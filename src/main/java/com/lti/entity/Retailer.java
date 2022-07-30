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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbl_retailer")
public class Retailer {
	
	@Id
	@SequenceGenerator(name="retailer_seq",initialValue=5001,allocationSize=1)
	@GeneratedValue(generator="retailer_seq",strategy=GenerationType.SEQUENCE)
	int retailerId;
	
	String retailerName;
	String retailerPassword;
	String retailerEmail;
	String retailerPhoneNo;
	String aadharCard;
	String panCard;
	boolean isRetailerApproved;
	String gstNo;
	
		
	@OneToMany(mappedBy="retailer")
	List<Product> products;

	
	
	
	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public int getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}

	public String getRetailerName() {
		return retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public String getRetailerPassword() {
		return retailerPassword;
	}

	public void setRetailerPassword(String retailerPassword) {
		this.retailerPassword = retailerPassword;
	}

	public String getRetailerEmail() {
		return retailerEmail;
	}

	public void setRetailerEmail(String retailerEmail) {
		this.retailerEmail = retailerEmail;
	}

	public String getRetailerPhoneNo() {
		return retailerPhoneNo;
	}

	public void setRetailerPhoneNo(String retailerPhoneNo) {
		this.retailerPhoneNo = retailerPhoneNo;
	}

	public boolean isRetailerApproved() {
		return isRetailerApproved;
	}

	public void setRetailerApproved(boolean isRetailerApproved) {
		this.isRetailerApproved = isRetailerApproved;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	@JsonIgnore
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
	

}
