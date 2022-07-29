package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Item;
import com.lti.entity.Product;

@Repository
public class RetailerDaoImpl implements RetailerDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Item AddOrUpdateProdcutToCart(Item item) {
		Item per = em.merge(item);
		return per;
	}

	@Override
	public Product getProductsbyItemId(int ItemId) {
		
		return em.find(Product.class,ItemId);
	}

}
