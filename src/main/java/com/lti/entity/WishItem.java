package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class WishItem {

	@Id
	@SequenceGenerator(name = "wishItem_seq", initialValue = 9001,allocationSize = 1)
	@GeneratedValue(generator = "wishItem-seq",strategy = GenerationType.SEQUENCE)
	int wishItemId;
	
	double quantity;
	
	@ManyToOne
	@JoinColumn(name="wishlistId")
	Wish wishlist;
	
	@ManyToOne
	@JoinColumn(name="productId")
	Product product;
	
	
	
}
