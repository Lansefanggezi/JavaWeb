package com.kang.spring.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kang.spring.annotation.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	
	public void HelloWorld()
	{
		System.out.println("UserController");
		service.save();
		
	}
	
	
	
	public UserService getService() {
		return service;
	}
	
}
