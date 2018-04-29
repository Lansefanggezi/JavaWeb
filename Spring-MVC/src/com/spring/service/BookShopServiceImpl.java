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
			
		//发现Book的价格
		int price = 	bookShopDao.findBookPriceByIsbn(isbn);
		
		//付钱
		bookShopDao.updateBookCountByIsbn(isbn);
		
		//	库存减一
		bookShopDao.updateUserBalanceByUserName(username, price);
			
	}

	/*
	 * 验证用户身份
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
