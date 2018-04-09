package com.kang.spring.trancationxml.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kang.spring.exception.BookStockException;
import com.kang.spring.exception.UserAcountException;

public class BookShopDaoImpl implements BookShopDao {

	JdbcTemplate jdbcTemplate ;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String updateSql = "select book_price from price where isbn=?";
		int price = jdbcTemplate.queryForObject(updateSql, Integer.class,isbn);
		return price;
	}

	@Override
	public int updateBookCountByIsbn(String isbn)   {
		//�����Ŀ���Ƿ�����
		String checkSql = "select stock from stock where isbn = ?";
		int checkrestule = jdbcTemplate.queryForObject(checkSql, Integer.class,isbn);
		if (checkrestule == 0) {
			throw new BookStockException("��治��");
		}
		String updateSql = "update stock set stock = stock-1 where isbn = ?";
		int result = jdbcTemplate.update(updateSql,isbn);

		return result;
	}

	@Override
	public int updateUserBalanceByUserName(String userName,int price) {
		//���������Ƿ�����
		String checkSql = "select balance from customers  where username = ?";
		int checkrestule = jdbcTemplate.queryForObject(checkSql, Integer.class,userName);
		if (checkrestule <price) {
			throw new UserAcountException("�û�����");
		}
		String updateSql = "update customers set balance =balance -  ?  where username = ?";
		int result = jdbcTemplate.update(updateSql,price,userName);
		
		return result;
	}

}