package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.RetailerDao;

import com.lti.entity.Item;
import com.lti.entity.Product;

@Service
public class RetailerServiceImpl implements RetailerService {
	@Autowired
	RetailerDao dao;

	@Override
	public Item AddOrUpdateProdcutToCart(Item item) {

		Item obj2 = dao.AddOrUpdateProdcutToCart(item);
		return obj2;

	}

	@Override
	public Product getProductsbyItemId(int itemId) {
		// TODO Auto-generated method stub
		return dao.getProductsbyItemId(itemId);
	}

}
