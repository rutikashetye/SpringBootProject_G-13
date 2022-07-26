package com.lti.service;

import java.util.List;

import javax.mail.Address;

import com.lti.dto.AddAddressDto;
import com.lti.dto.NewViewCartDto;
import com.lti.dto.UserResponseDto;
import com.lti.dto.ViewOrderDto;
import com.lti.entity.Cart;
import com.lti.entity.Category;
import com.lti.entity.Item;
import com.lti.entity.Payment;
import com.lti.entity.Product;
import com.lti.entity.User;
import com.lti.entity.UserAddress;
import com.lti.entity.WishItem;

public interface UserService {


//	UpdateUser updateProfile(User user);
	public User findUser(int userId);
	boolean userLogin(int userId, String password);
	public UserResponseDto addorUpdateUser(User user);
	public Cart getCartByCartId(int cartID);
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
	public List<NewViewCartDto> viewCart(int userId);
	public double getTotalAmount(int cartId);
	public double getTotalPriceAmount(int cartId);
	public String UpdateItem(int itemId, int quantity) ;
	public String removeItemFromWishList(int wishItemId);
	public String removeItemFromCart(int itemId);
	public String removeAddressFromAddress(int addressId);
	public String addorUpdateWishItem(WishItem wishitem);
	public List<ViewOrderDto> viewOrders(int cartId);
	
	
	public UserAddress addUserAddress(AddAddressDto userAddress);
	public List<UserAddress>viewUserAddressByUserId(int userId);
}
