package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name="tbl_wish")
public class Wish {
	@Id
	@SequenceGenerator(name = "wish_seq", initialValue = 8001,allocationSize = 1)
	@GeneratedValue(generator = "wish-seq",strategy = GenerationType.SEQUENCE)
	int wishlistId;
	
	
	@OneToOne
	@JoinColumn(name="userId")
	User user;

	@OneToMany(mappedBy = "wishlist")
	List<WishItem> items;

	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<WishItem> getItems() {
		return items;
	}

	public void setItems(List<WishItem> items) {
		this.items = items;
	}
	
	
	
	
}
