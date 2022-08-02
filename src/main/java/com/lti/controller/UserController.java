package com.lti.controller;

import java.util.List;

import javax.mail.Address;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dao.UserDao;
import com.lti.dto.AddAddressDto;
import com.lti.dto.AddToCartDto;
import com.lti.dto.NewViewCartDto;
import com.lti.dto.UserLoginData;
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
import com.lti.service.UserService;


@RestController
@RequestMapping("/paark")
@CrossOrigin
public class UserController {

	@Autowired
	UserService service;
	
	@Autowired
	UserDao dao;
	
	@PostMapping(value="/signup")
	public UserResponseDto signup(@RequestBody User user) {
		return service.addorUpdateUser(user);
	}
	
	@GetMapping("/user/{userId}")
	public User search(@PathVariable int userId)
	{
		return service.findUser(userId);
	}
	
	@PostMapping("/login")
	public boolean login(@RequestBody UserLoginData l)
	{
		boolean isValid = service.userLogin(l.getUserId(), l.getPassword());
		return isValid;
	}
	
	@GetMapping("/viewCartByCartId/{cartId}")
	public Cart getCartByCartId(@PathVariable int cartId)
	{
		return service.getCartByCartId(cartId);
	}
		
	@GetMapping("/sortByhighPrice/{category}")
	public List<Product> sortProductByHighPrice(@PathVariable String category) {
		return service.sortProductByHighPrice(category);
	}
	
	@GetMapping("/sortBylowPrice/{category}")
	public List<Product> sortProductByLowPrice(@PathVariable String category) {
		return service.sortProductByLowPrice(category);
	}

	@GetMapping(value = "/viewprodByColor/{color}/{category}")
	public List<Product> viewProductBasedOnColor(@PathVariable("color") String color,@PathVariable("category")String Category) {
		return service.viewProductBasedOnColor(color,Category);
	} 
	
	@GetMapping(value = "/viewproductByBrand/{brand}/{category}")
	public List<Product> viewProductBasedOnBrand(@PathVariable("brand") String brand,@PathVariable("category")String category) {
		return service.viewProductBasedOnBrand(brand,category);
	}
	
	@GetMapping("/viewTopProducts")
	public List<Product> viewFourHighestPriceProducts() {
		return service.viewFourHighestPriceProducts();
	}

	@PostMapping("/placeOrderFromCart/{cartId}")
	public String addToCart(@PathVariable int cartId ) {
		Payment payment=service.placeOrder(cartId); 
		if(payment!=null)
		{
			return "Order Placed .";
		}
		
	    return "Something Went Wrong. Try Again Later.";
	}
	
	@PostMapping(value="/addToCart/{productId}/{userId}/{quantity}")
	public String addToCart(@PathVariable("productId")int productId, @PathVariable ("userId")int userId,@PathVariable ("quantity")int quantity ) {
	    return service.AddtoCart(productId,userId,quantity); 
	}
	@GetMapping("/getColor/{category}")
	public List<String> getAllColors(@PathVariable String category) {
		return service.getAllcolors(category);
	}
	@GetMapping("/getBrand/{category}")
	public List<String> getAllBrands(@PathVariable String category) {
		return service.getAllBrands(category);
	}
	
	
	@GetMapping("/newProducts/{category}")
	public List<String> getNewestFirst(@PathVariable String category) {
		return service.getNewestProducts(category);
	}
	
	@GetMapping("/viewCart/{userId}")
	public List<NewViewCartDto>viewCart(@PathVariable int userId){
		return service.viewCart(userId);
	}
	@GetMapping("/getCartbyUserId/{userId}")
	public Cart getCartByUserId(@PathVariable int userId ) {
		return dao.findCartByUserId(userId);
	}
	@GetMapping("/getTotalAmount/{cartId}")
	public double getTotalAmount(@PathVariable int cartId){
		return service.getTotalAmount(cartId);
	}
	
	@GetMapping("/getTotalPriceAmount/{cartId}")
	public double getTotalPriceAmount(@PathVariable int cartId){
		return service.getTotalPriceAmount(cartId);
	}
	@PostMapping(value="/updateItem/{itemId}/{quantity}")
	public String updateItem(@PathVariable("itemId") int itemId,@PathVariable("quantity") int quantity) {
		return service.UpdateItem(itemId, quantity);
		
	}
	
	@DeleteMapping(value="/removeItemFromCart/{itemId}")
	public String removeItemFromCart(@PathVariable int itemId) {
		String message=service.removeItemFromCart(itemId);
		return message;
		
	}
	
	@DeleteMapping(value="/removeAddressFromAddress/{addressId}")
	public String removeAddressFromAddress(@PathVariable int addressId) {
		String message=service.removeAddressFromAddress(addressId);
		return message;
		
	}
	@DeleteMapping(value="/removeItemFromWishList/{wishItemId}")
	public String removeItemFromWishList(@PathVariable int wishItemId) {
		String message=service.removeItemFromWishList(wishItemId);
		return message;
		
	}
	
	@PostMapping(value="/addItemToWishList")
	public String addItemToWishList(@RequestBody WishItem wishitem) {
		String message=service.addorUpdateWishItem(wishitem);
		return message;
	}
	@GetMapping(value="/viewOrders/{cartId}")
	public List<ViewOrderDto> viewOrders(@PathVariable int cartId){
		return service.viewOrders(cartId);
	}
	
	@PostMapping("/addAddress")
	public UserAddress addUserAddress(@RequestBody AddAddressDto userAddress) {
		System.out.println(userAddress.getAddress().getBuilding());
		return service.addUserAddress(userAddress);
	}

	@GetMapping("/showAddresses/{userid}")
	public List<UserAddress> viewUserAddressByUserId(@PathVariable int userid) {
		System.out.println(userid);
		return service.viewUserAddressByUserId(userid);
	}


	
	
}
