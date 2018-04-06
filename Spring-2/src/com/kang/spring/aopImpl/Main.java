package com.kang.spring.aopImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

			ApplicationContext context  = new ClassPathXmlApplicationContext("AOP-AtithmeticCalculatorImpl.xml");
			AtithmeticCalculator calculatorImpl =  (AtithmeticCalculator) context.getBean("atithmeticCalculator");
			
			LoggingAspect aspect = context.getBean(LoggingAspect.class);
			
			int resultadd = calculatorImpl.add(1, 2);
			System.out.println("--->" + resultadd);
			
			int resultdiv = calculatorImpl.div(4, 2);
			System.out.println("--->" +resultdiv);
			
			
	}

}
