package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.BookShopDao;


@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;
	
	@Override
	public void buyBook(String username, String isbn) {
			
		//����Book�ļ۸�
		int price = 	bookShopDao.findBookPriceByIsbn(isbn);
		
		//��Ǯ
		bookShopDao.updateBookCountByIsbn(isbn);
		
		//	����һ
		bookShopDao.updateUserBalanceByUserName(username, price);
			
	}

}
