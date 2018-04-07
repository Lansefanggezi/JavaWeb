package com.kang.spring.jdbc;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class JDBCTest {

	private ApplicationContext context;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	{
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		namedParameterJdbcTemplate = context.getBean(NamedParameterJdbcTemplate.class);
	}
	
	/**
	 * 将sql中的参数封装成对象 参数和对象中的属性名必须一致
	 * 调用 SqlParameterSource 的实现类BeanPropertySqlParameterSource（）；
	 * */
	@Test
	public void testBeanParameterJdbcTemplate()
	{
		String url = "insert into customers (username,userpassword,balance) values(:username,:password,:balance)";
		
		User user = new User();
		user.setUsername("wangshaoming");
		user.setPassword("wang");
		user.setBalance(300);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		namedParameterJdbcTemplate.update(url, paramSource);
	}
	
	/**
	 * 可以给参数起名字
	 * 没有无参构造，必须给构造器赋值 DataSource
	 * */
	@Test
	public void testNameParemeterJdncTemplate()
	{
//		String url = "insert into customers (username,userpassword,balance) values(:name,:password,:balance)";
		String url = "update customers set balance = :balance where username = 'fandaoyan'";
		Map<String, Object> paramMap =  new HashMap<>();
		paramMap.put("name", "fandaoyan");
		paramMap.put("password", "fan");
		paramMap.put("balance", 300);
		namedParameterJdbcTemplate.update(url, paramMap);
		
	}
	/**
	 * 获取单个列的值，或者统计查询
	 * */
	@Test
	public void testQueryForObject()
	{
		String querySQL = "SELECT COUNT(*)  FroM  customers ";
		Long count =  jdbcTemplate.queryForObject(querySQL, long.class);
		System.out.println(count);
	}
	
	/**
	 * 获取集合的查询结果
	 * */
	@Test
	public void testQueryForList()
	{
		String sql = "SELECT username username, userpassword userpassword FROM customers ";
		RowMapper<User> user = new BeanPropertyRowMapper<>(User.class);
		
		List<User>  listuser = jdbcTemplate.query(sql, user);
		System.out.println(listuser);
	}
	/**
	 * 失败
	 * */
	@Test
	public void testQueryForObjec()
	{
		String sql = "SELECT username username, userpassword userpassword FROM customers ";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		
		User user = jdbcTemplate.queryForObject(sql, rowMapper, rowMapper);
		System.out.println(user.toString());
	}
	
	/**
	 * 测试批量更新数据
	 * */
	@Test
	public void testBatchUpdate()
	{
		String updateSQL = "INSERT INTO customers(username,userpassword)  VALUES(?,?)";
		List<Object[]> batchArgs = new LinkedList<>();
		batchArgs.add(new Object[]{"caoyanpei","cao"});
		batchArgs.add(new Object[]{"wangxiaoyang","wang"});
		
		jdbcTemplate.batchUpdate(updateSQL, batchArgs);
	}
	/**
	 * 测试更新方法
	 * */
	@Test
	public void testUpdate()
	{
		String updateSql = "insert into customers values(?,?)";
		jdbcTemplate.update(updateSql, "fanxueming", "fan");
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = context.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
	}

}
