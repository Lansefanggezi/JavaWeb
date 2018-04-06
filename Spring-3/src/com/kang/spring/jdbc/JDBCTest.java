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
	 * ��ȡ�����е�ֵ������ͳ�Ʋ�ѯ
	 * */
	@Test
	public void testQueryForObject()
	{
		String querySQL = "SELECT COUNT(*)  FroM  t_user ";
		Long count =  jdbcTemplate.queryForObject(querySQL, long.class);
		System.out.println(count);
	}
	
	/**
	 * ��ȡ���ϵĲ�ѯ���
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
	 * ʧ��
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
	 * ����������������
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
	 * ���Ը��·���
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
