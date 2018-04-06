package com.kang.spring.jdbc;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCTest {

	private ApplicationContext context;
	private JdbcTemplate jdbcTemplate;
	{
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
	}
	
	/**
	 * 获取单个列的值，或者统计查询
	 * */
	@Test
	public void testQueryForObject()
	{
		String querySQL = "SELECT COUNT(*)  FroM  t_user ";
		Long count =  jdbcTemplate.queryForObject(querySQL, long.class);
		System.out.println(count);
	}
	
	/**
	 * 获取集合的查询结果
	 * */
	@Test
	public void testQueryForList()
	{
		String sql = "SELECT username username, userpassword userpassword FROM t_user ";
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
		String sql = "SELECT username username, userpassword userpassword FROM t_user ";
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
		String updateSQL = "INSERT INTO t_user(username,userpassword)  VALUES(?,?)";
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
		String updateSql = "insert into t_user values(?,?)";
		jdbcTemplate.update(updateSql, "fanxueming", "fan");
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = context.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
	}

}
