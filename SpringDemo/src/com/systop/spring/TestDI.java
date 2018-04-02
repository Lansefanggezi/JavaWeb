package com.systop.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.systop.model.User;
import com.systop.service.impl.UserServiceImpl;

public class TestDI {
	@Test
	public void test() {
		User user= new User();
		user.setUserName("liuxiaoknag");
		user.setAge(18);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//��ȡservice
		UserServiceImpl userService = (UserServiceImpl)context.getBean("UserServiceImpl");
		
		userService.add(user);
	}

}
