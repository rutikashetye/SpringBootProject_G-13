package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Item;
import com.lti.entity.Product;
import com.lti.entity.Retailer;

@Repository
public class RetailerDaoImpl implements RetailerDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Item AddOrUpdateProdcutToCart(Item item) {
		Item per = em.merge(item);
		return per;
	}

	@Override
	public Product getProductsbyItemId(int ItemId) {
		
		return em.find(Product.class,ItemId);
	}

	@Override
	@Transactional
	public Product addOrUpdateProduct(Product product) {
		Product persistedProduct =em.merge(product);
		return persistedProduct;
	}
	
	@Override
	public Retailer searchRetailerById(int retailerId) {
		Retailer retailer = em.find(Retailer.class, retailerId);
		return retailer;
	}

	@Override
	public Product getProductByProductId(int productId) {
		Product p = em.find(Product.class, productId);
		return p;
	}
	
	@Transactional
	public Retailer addOrUpdateRetailer(Retailer retailer) {
		Retailer persistedRetailer = em.merge(retailer);
		return persistedRetailer;
	}
	
	public List<Product> viewAllProducts() {
		String jpql = "select p from Product p";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		return query.getResultList();
 }
	
	
	
}



