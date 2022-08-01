package com.lti;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.quartz.LocalDataSourceJobStore;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.lti.controller.AdminController;
import com.lti.controller.RetailerController;
import com.lti.controller.UserController;
import com.lti.dao.AdminDao;
import com.lti.dao.RetailerDao;
import com.lti.dao.UserDao;
import com.lti.entity.Admin;
import com.lti.entity.Cart;
import com.lti.entity.Category;
import com.lti.entity.Item;
import com.lti.entity.Payment;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.entity.User;
import com.lti.entity.orderStatus;
import com.lti.entity.payType;

@SpringBootTest
class ShopperspaarkApplicationTests {

//	@Autowired
//	AdminController con;
	
	@Autowired
	EntityManager em;
	
	@Autowired
	AdminController aCon;
	
	@Autowired
	RetailerController reCon;
	
	@Autowired
	UserController uCon;
	
	
	@Autowired
	RetailerDao redao;
	
	@Autowired
	UserDao udao;
	
//	@Test
//	void AddAdmin()
//	{
//		Admin a = new Admin();
//		a.setPassword("Admin@123");
//		String msg = con.signup(a);
//		assertEquals("Signup Successful",msg);
//	}
//	//Tested

//	@Test
//	void viewCart()
//	{
//		List<Item> li = uCon.viewCart(132);
//		for(Item i:li )
//		{
//			System.out.print(i.getProduct().getProductId());
//		}
//	}
//	
	
	@Test
	void addToCart()
	{
		Item i = new Item();
		Product p = reCon.searchProduct(1012);
		i.setProduct(p);
		i.setQuantity(2);
		User u = em.find(User.class,127);
		i.setCart(u.getCart());
		Item i2=reCon.addproductTocart(i);
		assertNotNull(i2);
	}
	
//	
//	@Test
//	void placeOrder() {
//		Cart c = uCon.getCartByCartId(4005);
//		Payment p = new Payment();
//		p.setStatus(orderStatus.placed);
//		p.setAmount(12000);
//		p.setPaymentDate(java.time.LocalDate.now());
//		p.setPaymentType(payType.cash);
//		p.setCart(c);
//		Payment p2 = uCon.placeOrder(p);
//		assertNotNull(p2);
//	}
//	
	
	@Test
	void addRetailer() {
			Retailer retailer=new Retailer();
			retailer.setGstNo("12345");
			retailer.setRetailerEmail("retailer@mail.com");
			retailer.setRetailerName("Jungkook");
			retailer.setRetailerPassword("12345");
			retailer.setRetailerPhoneNo("1234567899");
			retailer.setRetailerApproved(false);
			Retailer savedRetailer=redao.addOrUpdateRetailer(retailer);	
	}//TEsted
	
	
//	@Test 
//	void addProduct()
//	{
//		Retailer r = redao.searchRetailerById(5001);
//		Product product=new Product();
//		product.setBrand("Levis");
//		product.setCategory(Category.women);
//		product.setColor("blue");
//		product.setDeal(10);
//		product.setAvailable_quantity(400);
//		product.setDescription("jeans");
//		product.setDiscountedPrice(1500);
//		product.setPrice(1000);
//		product.setProductName("wide leg");
//		product.setRetailer(r);
//		String message=reCon.addProduct(product);
//		assertEquals("Product Added", message);
//	}
//	//Tested
//	
//	
//	
//	@Test
//	public void addorUpdateUserTest() {
//		User user = new User();
//		user.setuserName("Rutika Shetye");
//		user.setuserEmail("rutikashetye101@gmail.com");
//		user.setPhoneNo("9969802006");
//		user.setPassword("Rutika@123");
//		User savedUser = udao.addorUpdateUser(user);
//		assertNotNull(savedUser);
//	}//Tested
	
	
	@Test
	void viewAllProducts()
	{
		List<Product> p = reCon.viewAllProducts();
		for(Product in: p)
		{
			System.out.println(in.getDescription());
		}
	}//Tested
	
	
	
	@Test
	void isApproveTest()
	{
		String msg = aCon.approveRetailer(5002);
		System.out.println(msg);
	}
	
	
	
//	@Test
//	public void userLoginTest() {
//		boolean isValidUser = uCon.userLogin(121,"xyz@123");
//		
//		assertTrue(isValidUser);
//	}
//	Tested
	
}
