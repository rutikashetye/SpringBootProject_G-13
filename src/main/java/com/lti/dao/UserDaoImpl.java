package com.lti.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;
import com.lti.entity.Cart;
import com.lti.entity.User;


@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	EntityManager em;

	
//	public List<User> viewAllUsers() {
//		String jpql = "select usr from User usr";
//		TypedQuery<User> qry = em.createQuery(jpql, User.class);
//		return qry.getResultList();
//	}

	public boolean userLogin(int userId, String password) {
		User a = em.find(User.class,userId);
		if(a!=null)
		{
			if(a.getuserId()==userId && a.getPassword().equals(password))
			{
				return true;
			}
		}
		return false;
	}

	@Transactional
	public User addorUpdateUser(User user) {
		User userPersisted = em.merge(user);
		Cart c = new Cart();
		c.setUser(userPersisted);
		addCart(c);
		return userPersisted;
		}
	
	@Transactional
	public void addCart(Cart c)
	{
		em.merge(c);
	}
	
	
	
}
