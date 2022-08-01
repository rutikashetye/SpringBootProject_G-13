package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.dto.AddProductDto;
import com.lti.entity.Category;
import com.lti.entity.Item;
import com.lti.entity.Product;
import com.lti.entity.Retailer;

@Repository
public class RetailerDaoImpl implements RetailerDao {

	@PersistenceContext
	EntityManager em;
	

	
	@Override
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
	public Product getProductByProductId(int productId) {
		Product p = em.find(Product.class, productId);
		return p;
	}
	

	@Override
	@Transactional
	public Retailer addOrUpdateRetailer(Retailer retailer) {
		Retailer persistedRetailer = em.merge(retailer);
		return persistedRetailer;
	}

	@Override
	public Retailer searchRetailerById(int retailerId) {
		Retailer retailer = em.find(Retailer.class, retailerId);
		return retailer;
	}

	@Override
	public boolean loginRetailer(int retailerId, String retailerPassword) {
		Retailer retailer = searchRetailerById(retailerId);
		if (retailer.getRetailerPassword().equals(retailerPassword)) {
			System.out.println(retailer.isRetailerApproved());
			if(retailer.isRetailerApproved()) {
				return true;
		}}
			
		return false;

	}


	@Override
	@Transactional
	public Product addOrUpdateProduct(AddProductDto dto) {
		int retailerId=dto.getRetailerId();
		Retailer retailer=searchRetailerById(retailerId);
		Product p=dto.getProduct();
		p.setRetailer(retailer);
		Product product=em.merge(p);
		return product;
	}



//is_notApproved_products
	public List<Product> viewAllProducts() {
		String jpql = "select p from Product p where p.isApproved=false";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		return query.getResultList();
	}

	//is_notApproved Retailer
	public List<Retailer> viewAllRetailer() {
		String jpql = "select p from Retailer p where p.isRetailerApproved=false";
		TypedQuery<Retailer> query = em.createQuery(jpql,Retailer.class);
		return query.getResultList();
	}

	public List<Product> viewProductBasedOnCategory(String category) {
		String jpql = "select p from Product p where p.category=:prodcategory";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		query.setParameter("prodcategory", Category.valueOf(category));
		return query.getResultList();

	}
}
