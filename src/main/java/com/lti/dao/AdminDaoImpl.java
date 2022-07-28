package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao{

	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public boolean adminLogin(int adminId, String password) {
		
		Admin a = em.find(Admin.class,adminId);
		if(a!=null)
		{
			if(a.getAdminId()==adminId && a.getPassword().equals(password))
			{
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

}
