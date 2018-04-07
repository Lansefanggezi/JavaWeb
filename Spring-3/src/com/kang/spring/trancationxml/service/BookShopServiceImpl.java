package com.kang.spring.trancationxml.service;

import com.kang.spring.trancationxml.dao.BookShopDao;

public class BookShopServiceImpl implements BookShopService {

	private BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
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
