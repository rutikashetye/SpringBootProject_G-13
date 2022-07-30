package com.lti.dao;

import java.util.List;

import javax.mail.Address;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.entity.Retailer;
import com.lti.entity.User;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean adminLogin(int adminId, String password) {
		Admin a = em.find(Admin.class, adminId);
		if (a != null) {
			if (a.getAdminId() == adminId && a.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Transactional
	public Admin addAdmin(Admin admin) {
		Admin Persisted = em.merge(admin);
		return Persisted;
	}

	@Override
	public List<Product> is_approvedProducts() {
		String jpql = "select p from tbl_product p where p.isApproved=true";
		TypedQuery<Product> qry = em.createQuery(jpql, Product.class);
		return qry.getResultList();
	}

	@Transactional
	public String approveProduct(int productId) {
		Product r = em.find(Product.class, productId);
		if (r != null) {
			r.setApproved(true);
			em.merge(r);
			return "Products Approved";
		}
		return "Products not approved.";
	}

	@Transactional
	public String approveRetailer(int retailerId) {
		Retailer r = em.find(Retailer.class, retailerId);
		if (r != null) {
			r.setRetailerApproved(true);
			em.merge(r);
			return "Retailer Approved";
		}
		return "Retailer not approved.";
	}

	public List<Product> viewAllProducts() {
		String jpql = "select p from Product p";
		TypedQuery<Product> query = em.createQuery(jpql, Product.class);
		return query.getResultList();
	}

	public List<Retailer> viewAllRetailer() {
		String jpql = "select p from Retailer p";
		TypedQuery<Retailer> query = em.createQuery(jpql, Retailer.class);
		return query.getResultList();
	}

}
