package com.kang.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kang.spring.annotation.controller.UserController;

public class Main {

	public static void main(String[] args) {

			ApplicationContext context = new ClassPathXmlApplicationContext("beans-annotation.xml");
			UserController UserController =  (com.kang.spring.annotation.controller.UserController) context.getBean("userController");
			UserController.HelloWorld();
	}

}
