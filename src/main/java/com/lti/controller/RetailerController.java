package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Item;
import com.lti.entity.Product;
import com.lti.entity.User;
import com.lti.service.RetailerService;


@RestController
@RequestMapping("/paark")
@CrossOrigin
public class RetailerController {

	@Autowired
	RetailerService service;
	
	@RequestMapping(value="/addcart",method=RequestMethod.POST)
	public Item addproductTocart(@RequestBody Item item) {
		Item item2=service.AddOrUpdateProdcutToCart(item); 
	    return item2;
	}
	
	@PostMapping("/viewProduct")
	public Product search(@RequestBody int itemId)
	{
		return service.getProductsbyItemId(itemId);
	}
	
	
	
	
}
