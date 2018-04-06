package com.kang.spring.bean.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans-spel.xml");
		Car car =  (Car) context.getBean("car");
		System.out.println(car.toString());
		
		Address address = context.getBean(Address.class);
		System.out.println(address.toString());
				
		Person person = context.getBean(Person.class);
		System.out.println(person.toString());
		
		
	}

}
