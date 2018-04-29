package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.entitiy.Customers;
import com.spring.service.BookShopService;

//将类声明为Spring容器当中的bean，当调用时对该类实例化
@Controller
//声明Controller处理的请求 类级别
@RequestMapping("/Spring-MVC") 
public class BookShopController {

	@Autowired
	private BookShopService bookShopService;
	
	//登陆
	@RequestMapping("/buyBook")
	public  String pringWelcome(Customers customers)
	{
		//验证是否存在
		int resutl =  bookShopService.checkCustomers(customers);
		
		//返回hello交由ViewResolver
		if(resutl == 1)
			return "/hello";
		else
			return "/index";
	}
	//注册
	@RequestMapping("/register")
	public String register(Customers customers)
	{
		int resutl =  bookShopService.registerCustomers(customers);
		
		//返回hello交由ViewResolver
		if(resutl == 1)
			return "/hello";
		else
			return "/index";
	}
}
