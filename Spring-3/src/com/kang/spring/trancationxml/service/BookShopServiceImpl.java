package com.kang.spring.trancationxml.service;

import com.kang.spring.trancationxml.dao.BookShopDao;

public class BookShopServiceImpl implements BookShopService {

	private BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
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
