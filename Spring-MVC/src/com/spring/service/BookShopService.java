package com.spring.service;

import com.spring.entitiy.Customers;

public interface BookShopService {

	//����
	void buyBook(String username, int isbn);
	
	//��֤���
	int checkCustomers(Customers customers);
	
	//ע���û�
	int registerCustomers(Customers customers);
}
