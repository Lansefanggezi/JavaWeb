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
		//ʹ�Ø�����ע��r���п��������o���R�e��ͬ�Ę�������������Ҫͨ�^��ͬ�ą�������������́���������^�e
		
	}

}
