package com.lti.service;

import java.util.List;

import javax.mail.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.UserDao;
import com.lti.dto.AddAddressDto;
import com.lti.dto.NewViewCartDto;
import com.lti.dto.RegResponseDto;
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

@Service
public class UserServieImpl implements UserService {

	@Autowired
	UserDao dao;
	
	@Autowired
	EmailService service;

	@Override
	public List<NewViewCartDto> viewCart(int userId) {
		List<NewViewCartDto>list=dao.viewCart(userId);
		return list;
	}
	
	public UserResponseDto addorUpdateUser(User user) {
		try {
			User user2 = dao.addOrUpdateUser(user);
			String email = user2.getuserEmail();
			String text = "Your userId is:" + user2.getuserId()
			+" and Password is:"+user2.getPassword()+". Please do not share your login details with anyone for security reasons.";
			String subject = "Registration confirmation";
			service.sendEmail(email, text, subject);							
			System.out.println("Email sent.");
			UserResponseDto dto = new UserResponseDto();
			dto.setUserId(user2.getuserId());
			dto.setMessage(text);
			return dto;
		} catch (Exception e) {
			UserResponseDto dto = new UserResponseDto();
			dto.setUserId(0);
			dto.setMessage("Unexpected error occured. Signup failed");
			return dto;
		}
	}
	
	@Override
	public Payment placeOrder(int cartId) {
		Payment payment2=dao.placeOrder(cartId);
		return payment2;
	}
	
	public User findUser(int userId) {
		// TODO Auto-generated method stub
		return dao.searchUserById(userId);
	}
	public boolean userLogin(int userId, String password) {
		// TODO Auto-generated method stub
		return dao.login(userId, password);
	}
	
	@Override
	public String UpdateItem(int itemId, int quantity) {
		String msg=dao.UpdateItem(itemId, quantity);
		return msg;
	}
	@Override
	public Cart getCartByCartId(int cartID) {
		// TODO Auto-generated method stub
		return dao.getCartByCartId(cartID);
	}


	@Override
	public List<Product> sortProductByHighPrice(String category) {
		return dao.sortProductByHighPrice(category);
	}
	
	@Override
	public List<Product> sortProductByLowPrice(String category) {
		return dao.sortProductByHighPrice(category);
	}
	
	public List<Product> viewProductBasedOnColor(String color,String category) {
		return dao.viewProductBasedOnColor(color,category);
	}
	
	public List<Product> viewProductBasedOnBrand(String brand,String category) {
		return dao.viewProductBasedOnBrand(brand,category);
	}
	public List<Product> viewFourHighestPriceProducts() {
		return dao.viewFourHighestPriceProducts();
	}

	@Override
	public String AddtoCart(int productId, int userId,int quantity) {
		String msg=dao.AddtoCart(productId, userId,quantity);
		return msg;
	}

	@Override
	public List<String> getAllcolors(String cat) {
		// TODO Auto-generated method stub
		return dao.getAllColors(cat);
	}

	@Override
	public List<String> getAllBrands(String cat) {
		// TODO Auto-generated method stub
		return dao.getAllBrands(cat);
	}
	
	public List<String> getNewestProducts(String category){
		// TODO Auto-generated method stub
		return dao.getAllBrands(category);
	}
	@Override
	public double getTotalAmount(int cartId) {
		return dao.getTotalAmount(cartId);
	}
	@Override
	public double getTotalPriceAmount(int cartId) {
		return dao.getTotalPriceAmount(cartId);
	}
	@Override
	public String removeItemFromWishList(int wishItemId) {
		String msg=dao.removeItemFromWishList(wishItemId);
		return msg;
	}

	@Override
	public String removeItemFromCart(int itemId) {
		String msg=dao.removeItemFromCart(itemId);
		return msg;
	}

	@Override
	public String removeAddressFromAddress(int addressId) {
		String msg=dao.removeAddressFromAddress(addressId);
		return msg;
	}
	@Override
	public String addorUpdateWishItem(WishItem wishitem) {
		try {
			WishItem wishitempersisted=dao.addorUpdateWishItem(wishitem);	
			return "Item added to Wishlist";
			}
			catch(Exception e)
			{
				return"Could not add item in Wishlist";
			}
	}
	
	@Override
	public List<ViewOrderDto> viewOrders(int cartId) {
		return dao.viewOrders(cartId);
	}

	@Override
	public UserAddress addUserAddress(AddAddressDto userAddress){
	
		return dao.addUserAddress(userAddress);
	}

	@Override
	public List<UserAddress>viewUserAddressByUserId(int userId) {
		return dao.viewUserAddressByUserId(userId);
	}


	
	
	
}
