package com.kang.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kang.dao.UserMapper;
import com.kang.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext1.xml")
public class TestSM {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testSave() {
		User user = new User();
		user.setId(1);
		user.setName("liuxiaokang");
		user.setBirthday(new Date());
		user.setSalary(5000);
		userMapper.save(user);
	}
	
	@Test
	public void testUpdate()
	{
		User user = new User();
		user.setId(-1);
		user.setName("liuxiaokang");
		user.setBirthday(new Date());
		user.setSalary(500000);
		userMapper.update(user);
	}
	
	@Test
	public void testfindById()
	{
		User user =  userMapper.findById(1);
		System.out.println(user);
	}
	
	@Test
	public void testfindAll()
	{
		List<User> list =  userMapper.findAll();
		System.out.println(list);
	}
}
