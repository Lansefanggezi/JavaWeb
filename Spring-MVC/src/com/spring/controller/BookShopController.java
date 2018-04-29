package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.entitiy.Customers;
import com.spring.service.BookShopService;

//��������ΪSpring�������е�bean��������ʱ�Ը���ʵ����
@Controller
//����Controller��������� �༶��
@RequestMapping("/Spring-MVC") 
public class BookShopController {

	@Autowired
	private BookShopService bookShopService;
	
	//��½
	@RequestMapping("/buyBook")
	public  String pringWelcome(Customers customers)
	{
		//��֤�Ƿ����
		int resutl =  bookShopService.checkCustomers(customers);
		
		//����hello����ViewResolver
		if(resutl == 1)
			return "/hello";
		else
			return "/index";
	}
	//ע��
	@RequestMapping("/register")
	public String register(Customers customers)
	{
		int resutl =  bookShopService.registerCustomers(customers);
		
		//����hello����ViewResolver
		if(resutl == 1)
			return "/hello";
		else
			return "/index";
	}
}
