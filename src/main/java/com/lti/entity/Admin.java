package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_admin")
public class Admin {
	@Id
	@SequenceGenerator(name="admin_seq",initialValue = 786, allocationSize = 1)
	@GeneratedValue(generator = "admin_seq", strategy = GenerationType.SEQUENCE)
	int adminId;
	String password;
	public int getAdminId() {
		return adminId;
	}
	public String getPassword() {
		return password;
	}
	
	
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
