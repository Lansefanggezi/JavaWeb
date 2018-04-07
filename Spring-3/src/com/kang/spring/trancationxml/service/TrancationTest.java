package com.kang.spring.trancationxml.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kang.spring.trancationxml.dao.BookShopDao;

public class TrancationTest {

	private BookShopDao bookShopDao;
	private ApplicationContext context;
	private BookShopService bookShopService;
	
	{
		context = new ClassPathXmlApplicationContext("ApplicationContext-tx-xml.xml");
		bookShopDao = context.getBean(BookShopDao.class);
		bookShopService = (BookShopService) context.getBean("bookShopService");
	}
	
	
	@Test
	public void testFindBookPrice() {
		int result = bookShopDao.findBookPriceByIsbn("1");
		System.out.println(result);
	}
	
	@Test
	public void testupdateBookCountByIsbn()
	{
		int result =  bookShopDao.updateBookCountByIsbn("1");
		System.out.println(result);
	}
	
	@Test
	public void testupdateUserBalanceByUserName()
	{
		int resutl = bookShopDao.updateUserBalanceByUserName("liuxiaokang", 4000);
		System.out.println(resutl);
	}
	
	@Test
	public void  testBuyBook() {
		bookShopService.buyBook("liuxiaokang", "1");
	}
}
