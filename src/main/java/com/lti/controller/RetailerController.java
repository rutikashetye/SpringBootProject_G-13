package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.service.RetailerService;


@RestController
@RequestMapping("/paark")
@CrossOrigin
public class RetailerController {

	@Autowired
	RetailerService service;
	
}
