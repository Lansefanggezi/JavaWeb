package com.kang.spring.trancation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kang.spring.exception.BookStockException;
import com.kang.spring.exception.UserAcountException;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	@Override
	public int findBookPriceByIsbn(String isbn) {
		String updateSql = "select book_price from price where isbn=?";
		int price = jdbcTemplate.queryForObject(updateSql, Integer.class,isbn);
		return price;
	}

	@Override
	public int updateBookCountByIsbn(String isbn)   {
		//检查书的库存是否重组
		String checkSql = "select stock from stock where isbn = ?";
		int checkrestule = jdbcTemplate.queryForObject(checkSql, Integer.class,isbn);
		if (checkrestule == 0) {
			throw new BookStockException("库存不足");
		}
		String updateSql = "update stock set stock = stock-1 where isbn = ?";
		int result = jdbcTemplate.update(updateSql,isbn);

		return result;
	}

	@Override
	public int updateUserBalanceByUserName(String userName,int price) {
		//检查用余额是否重组
		String checkSql = "select balance from customers  where username = ?";
		int checkrestule = jdbcTemplate.queryForObject(checkSql, Integer.class,userName);
		if (checkrestule <price) {
			throw new UserAcountException("用户余额不足");
		}
		String updateSql = "update customers set balance =balance -  ?  where username = ?";
		int result = jdbcTemplate.update(updateSql,price,userName);
		
		return result;
	}

}
