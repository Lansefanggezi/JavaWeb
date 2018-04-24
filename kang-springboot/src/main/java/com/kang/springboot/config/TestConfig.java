package com.kang.springboot.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfig {

	
	public  static void  main(String[] args)
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext 
		= new AnnotationConfigApplicationContext(SpringConfig.class);
		UserService userService = (UserService)annotationConfigApplicationContext.getBean(UserService.class);
		userService.printUser();
		System.out.println("___________");
		annotationConfigApplicationContext.close();
	}
}
