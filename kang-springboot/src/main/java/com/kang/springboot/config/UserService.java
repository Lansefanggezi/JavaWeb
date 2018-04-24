package com.kang.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public void printUser()
	{
		System.out.println(userDAO.getUserList());
	}
}
