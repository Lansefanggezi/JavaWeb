package com.kang.spring.bean.factooryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans-factory.xml");
		Car car  = (Car) context.getBean("car");
//		Car car = factoryBean.getObject();
		System.out.println(car.toString());
		
	}

}
