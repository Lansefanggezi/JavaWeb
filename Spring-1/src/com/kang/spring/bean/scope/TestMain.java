package com.kang.spring.bean.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.PessimisticLockingFailureException;

import com.kang.spring.bean.autowire.Car;
import com.kang.spring.bean.autowire.Person;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-scope.xml");
		
		Car car  = context.getBean(Car.class);
		Car car2  = context.getBean(Car.class);
		System.out.println(car.toString());
		System.out.println(car2.toString());
		
		System.out.println(car == car2);

	}

}
