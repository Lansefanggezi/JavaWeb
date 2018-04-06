package com.kang.spring.bean.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans-factory.xml");
		Car car = (Car) context.getBean("car2");
		System.out.println(car.toString());
	}

}
