package com.kang.spring.trancation.service;

import static org.junit.Assert.*;

import javax.naming.Context;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.kang.spring.trancation.dao.BookShopDao;

public class TrancationTest {

	private BookShopDao bookShopDao;
	private ApplicationContext context;
	private BookShopService bookShopService;
	
	{
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		bookShopDao = context.getBean(BookShopDao.class);
		bookShopService = context.getBean(BookShopService.class);
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
	
	@Transactional
	@Test
	public void  testBuyBook() {
		bookShopService.buyBook("liuxiaokang", "1");
	}
}
