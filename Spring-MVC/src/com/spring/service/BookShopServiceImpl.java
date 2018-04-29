package com.spring.service;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.BookShopDao;
import com.spring.entitiy.Customers;


@Service()
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;
	
	@Override
	@Transactional
	public void buyBook(String username, int isbn) {
			
		//����Book�ļ۸�
		int price = 	bookShopDao.findBookPriceByIsbn(isbn);
		
		//��Ǯ
		bookShopDao.updateBookCountByIsbn(isbn);
		
		//	����һ
		bookShopDao.updateUserBalanceByUserName(username, price);
			
	}

	/*
	 * ��֤�û����
	 * */
	@Override
	public int checkCustomers(Customers customers) {
		
		int cus = bookShopDao.findUserByNameAndPassWord(customers);
		
		return cus;
	}
	@Override
	public int  registerCustomers(Customers customers)
	{
		int result = bookShopDao.insertUser(customers);
		return result;
	}
}
