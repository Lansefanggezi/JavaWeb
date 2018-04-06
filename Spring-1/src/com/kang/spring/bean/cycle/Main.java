package com.kang.spring.bean.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-cycle.xml");
		Car car =  context.getBean(Car.class);
		
		context.close();
	}

}
