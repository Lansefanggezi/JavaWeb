package com.kang.spring.aopxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

			ApplicationContext context  = new ClassPathXmlApplicationContext("ApplicationContextr.xml");
			AtithmeticCalculator calculatorImpl =  (AtithmeticCalculator) context.getBean("atithmeticCalculatorImpl");
			
			LoggingAspect aspect = context.getBean(LoggingAspect.class);
			
			int resultadd = calculatorImpl.add(1, 2);
			System.out.println("--->" + resultadd);
			
			int resultdiv = calculatorImpl.div(4, 2);
			System.out.println("--->" +resultdiv);
			
			
	}

}
