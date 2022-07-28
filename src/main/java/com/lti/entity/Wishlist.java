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
public class Wishlist {
	@Id
	@SequenceGenerator(name="wishlist_seq",initialValue=8001,allocationSize=1)
	@GeneratedValue(generator="wishlist_seq",strategy=GenerationType.SEQUENCE)
	int wishlistId;
	
	@OneToOne
	User user;
	
	@OneToMany(mappedBy="wishlist")
	List<Item>items;

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

	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}

	public User getCustomer() {
		return user;
	}

	public void setCustomer(User user) {
		this.user = user;
	}
	
	

}
