package com.lti;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.controller.AdminController;
import com.lti.dao.AdminDao;
import com.lti.dao.UserDao;
import com.lti.entity.Admin;
import com.lti.entity.Product;

@SpringBootTest
class ShopperspaarkApplicationTests {

	@Autowired
	AdminController con;
	
	@Test
	void AddAdmin()
	{
		Admin a = new Admin();
		a.setPassword("admin123");
		String msg = con.signup(a);
		assertEquals("Signup Successful",msg);
		
	}

}
