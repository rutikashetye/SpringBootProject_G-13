package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.UserDao;

@Service
public class UserServieImpl implements UserService {

	@Autowired
	UserDao dao;
}
