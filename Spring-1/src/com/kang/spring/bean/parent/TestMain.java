package com.kang.spring.bean.parent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kang.spring.bean.autowire.Person;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("parent-bean.xml");
		
		Person person = (Person) context.getBean("person");
		
		System.out.println(person.toString());
	}

}
