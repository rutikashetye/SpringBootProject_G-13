package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AddToCartDto;
import com.lti.dto.UserLoginData;
import com.lti.dto.UserResponseDto;
import com.lti.entity.Cart;
import com.lti.entity.Category;
import com.lti.entity.Payment;
import com.lti.entity.Product;
import com.lti.entity.User;
import com.lti.service.UserService;


@RestController
@RequestMapping("/paark")
@CrossOrigin
public class UserController {

	@Autowired
	UserService service;
	
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
	
	@RequestMapping(value="/placeOrder",method=RequestMethod.POST)
	public Payment placeOrder(@RequestBody Payment p) {
		Payment m=service.placeOrder(p); 
	    return m;
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

	@PostMapping("/placeOrder/{cartid}")
	public Payment addToCart(@PathVariable int cartId ) {
		Payment payment=service.placeOrder(cartId); 
	    return payment;
	}
	
	@PostMapping(value="/addToCart/{productId}/{userId}/{quantity}")
	public String addToCart(@PathVariable("productId")int productId, @PathVariable ("userId")int userId,@PathVariable ("quantity")int quantity ) {
		String m=service.AddtoCart(productId,userId,quantity); 
	    return m;
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
}
