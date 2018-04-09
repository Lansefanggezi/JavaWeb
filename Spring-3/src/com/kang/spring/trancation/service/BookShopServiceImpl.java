package com.kang.spring.trancation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kang.spring.trancation.dao.BookShopDao;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;
	
	@Override
	public void buyBook(String username, String isbn) {
			
		//发现Book的价格
		int price = 	bookShopDao.findBookPriceByIsbn(isbn);
		
		//付钱
		bookShopDao.updateBookCountByIsbn(isbn);
		
		//	库存减一
		bookShopDao.updateUserBalanceByUserName(username, price);
			
	}

}
