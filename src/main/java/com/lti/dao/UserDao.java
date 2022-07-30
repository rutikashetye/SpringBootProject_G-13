package com.lti.dao;

import java.util.List;

import com.lti.entity.Cart;
import com.lti.entity.User;




public interface UserDao {

//	addOrUpdateUser(User user)  [prabhat]
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
	
	User addorUpdateUser(User user);
	boolean userLogin(int userId,String password);
	
	void addCart(Cart cart);
	
	
}
