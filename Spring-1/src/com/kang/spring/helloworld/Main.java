package com.kang.spring.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//		HelloWorld helloWorld =  (HelloWorld) context.getBean("helloworld");
//		
//		helloWorld.hello();
//		
//		Car car =  (Car) context.getBean("Car");
//		System.out.println(car.toString());
		
		Car car2 = (Car) context.getBean("car2");
		System.out.println(car2.toString());;
		//使用構造器注入時。有可能容器無法識別不同的構造器。所以需要通過不同的參數個數或者類型來幫助容器區別
		
	}

}
