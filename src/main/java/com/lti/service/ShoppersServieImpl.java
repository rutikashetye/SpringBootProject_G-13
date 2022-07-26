package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ShoppersDao;

@Service
public class ShoppersServieImpl implements ShoppersService {

	@Autowired
	ShoppersDao dao;
}
