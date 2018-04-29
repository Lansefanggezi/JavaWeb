package com.spring.service;

import com.spring.entitiy.Customers;

public interface BookShopService {

	//买书
	void buyBook(String username, int isbn);
	
	//验证身份
	int checkCustomers(Customers customers);
	
	//注册用户
	int registerCustomers(Customers customers);
}
