package com.spring.dao;

import com.spring.entitiy.Customers;

public interface BookShopDao {

	//查询用户是否存在
	 int findUserByNameAndPassWord(Customers customers);
	
	//注册用户
	 int insertUser(Customers customers);
	
	//查询书的价格根据书的编号
	 int findBookPriceByIsbn(int isbn);
	
	//更新书的数量，默认书的的数量减一
	 int updateBookCountByIsbn(int isbn);
	
	//跟新用户的钱包余额
	 int updateUserBalanceByUserName(String userName, int price);
}
