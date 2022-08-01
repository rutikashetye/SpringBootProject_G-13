package com.lti.service;

import java.util.List;

import com.lti.dto.UserResponseDto;
import com.lti.entity.Cart;
import com.lti.entity.Category;
import com.lti.entity.Payment;
import com.lti.entity.Product;
import com.lti.entity.User;

public interface UserService {


//	UpdateUser updateProfile(User user);
	public User findUser(int userId);
	boolean userLogin(int userId, String password);
	public UserResponseDto addorUpdateUser(User user);
	public Cart getCartByCartId(int cartID);
	public Payment placeOrder(Payment p);
	public List<Product> sortProductByHighPrice(String cat);
	public List<Product> sortProductByLowPrice(String category);
	public List<Product> viewProductBasedOnColor(String color,String category);
	public List<Product> viewProductBasedOnBrand(String brand,String category);
	public List<Product> viewFourHighestPriceProducts();
	public Payment placeOrder(int cartId);
	public String AddtoCart(int productId, int userId,int quantity);
	public List<String> getAllcolors(String cat);
	public List<String> getAllBrands(String cat);
	public List<String> getNewestProducts(String category);
}
