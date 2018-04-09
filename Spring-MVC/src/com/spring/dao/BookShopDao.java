package com.spring.dao;

public interface BookShopDao {

	//查询用户是否存在
	public int findUserByNameAndPassWord(String userName, String password);
	
	//注册用户
	public void updateUser(String username,String password);
	
	//查询书的价格根据书的编号
	public int findBookPriceByIsbn(String isbn);
	
	//更新书的数量，默认书的的数量减一
	public int updateBookCountByIsbn(String isbn);
	
	//跟新用户的钱包余额
	public int updateUserBalanceByUserName(String userName, int price);
}
