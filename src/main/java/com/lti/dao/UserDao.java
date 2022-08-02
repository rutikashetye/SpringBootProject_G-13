package com.lti.dao;

import java.util.List;

import javax.mail.Address;

import com.lti.dto.AddAddressDto;
import com.lti.dto.NewViewCartDto;
import com.lti.entity.Cart;
import com.lti.entity.Category;
import com.lti.entity.Payment;
import com.lti.entity.Product;
import com.lti.entity.User;
import com.lti.entity.UserAddress;
import com.lti.entity.WishItem;
import com.lti.dto.ViewOrderDto;
import com.lti.entity.Item;



public interface UserDao {


//			findUserByUserId(int userId)   [prabhat]
//			findCartByUserId(int userId)   [prabhat]
//			findUserByCartId(int cartId)   [prabhat]
//			viewAllProducts()   [ani]
//			findOrderByCartId(int cartId)   [aman]
//			findOrderByOrderId(int orderId)   [aman]
//			findTotalAmountByCartId(int cartId)  [aman]
//			findTotalAmountByOrderId(int orderId)  [aman]
//			findTotalItemsByCartId(int cartId)  [aman]
//			findWishlistByUserId(int userId) [ru]
//			placeOrder(Order order)    [ru]
//			findOrderByUserId(int userId)  [ru]
	public List<ViewOrderDto> viewOrders(int cartId);
	public double getTotalAmount(int cartId);
	public User addOrUpdateUser(User user );
	public User searchUserById(int userID);
	boolean login(int userId, String password);
	public Cart getCartByCartId(int cartId);
	public List<Product> sortProductByHighPrice(String cat);
	public List<Product> sortProductByLowPrice(String category);
	public List<Product> viewProductBasedOnColor(String color,String category);
	public List<Product> viewProductBasedOnBrand(String brand,String category);
	public List<Product> viewFourHighestPriceProducts();
	public Payment placeOrder(int cartId);
	public Cart findCartByCartId(int cartId);
	public String AddtoCart(int productId,int userId,int quantity);
	public Cart findCartByUserId(int userId);
	public List<String> getAllColors(String category);
	public List<String> getAllBrands(String category);
	public List<String> getNewestProducts(String category);
	public List<NewViewCartDto> viewCart(int userId);
	public double getTotalPriceAmount(int cartId);
	public String UpdateItem(int itemId, int quantity);
	
	public String removeItemFromWishList(int wishItemId);
	public String removeItemFromCart(int itemId) ;
	public String removeAddressFromAddress(int addressId);
	public Item getItemByItemId(int itemId);
	public WishItem addorUpdateWishItem(WishItem wishitem);
	
	public UserAddress addUserAddress(AddAddressDto userAddress);
	public List<UserAddress>viewUserAddressByUserId(int userId) ;
	
	
	
	
}
