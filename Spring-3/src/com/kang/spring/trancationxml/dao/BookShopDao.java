package com.kang.spring.trancationxml.dao;

public interface BookShopDao {

	//查询书的价格根据书的编号
	public int findBookPriceByIsbn(String isbn);
	
	//更新书的数量，默认书的的数量减一
	public int updateBookCountByIsbn(String isbn);
	
	//跟新用户的钱包余额
	public int updateUserBalanceByUserName(String userName, int price);
}
