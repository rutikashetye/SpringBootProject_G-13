package com.lti;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.controller.AdminController;
import com.lti.controller.RetailerController;
import com.lti.dao.AdminDao;
import com.lti.dao.UserDao;
import com.lti.entity.Admin;
import com.lti.entity.Cart;
import com.lti.entity.Item;
import com.lti.entity.Product;

@SpringBootTest
class ShopperspaarkApplicationTests {

	@Autowired
	AdminController con;
	
	@Autowired
	RetailerController reCon;
	
//	@Test
//	void AddAdmin()
//	{
//		Admin a = new Admin();
//		a.setPassword("admin123");
//		String msg = con.signup(a);
//		assertEquals("Signup Successful",msg);
//		
//	}
//	//Tested

	@Test
	void addCart()
	{
		Item i = new Item();
		Product p = new Product();
		Cart c = new Cart();
		i.setProduct(p);
		i.setQuantity(2);
		i.setCart(c);
		Item i2=reCon.addproductTocart(i);
		assertNotNull(i2);
	}
	
	
}
