package com.kang.spring.bean.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean-autowire.xml");
		
		Person person = context.getBean(Person.class);
		
		System.out.println(person.toString());
	}

}
