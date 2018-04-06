package com.kang.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

//			ApplicationContext context  = new ClassPathXmlApplicationContext("AOP-AtithmeticCalculatorImpl.xml");
//			AtithmeticCalculatorImpl calculatorImpl = (com.kang.spring.aop.AtithmeticCalculatorImpl) context.getBean("atithmeticCalculatorImpl");
//			
			AtithmeticCalculator calculatorImpl =  new AtithmeticCalculatorImpl();
			AtithmeticCalculator proxy = (AtithmeticCalculator) new AtithmeticCalculatorLoggingProxy(calculatorImpl).getProxy();
			
			int resultadd = proxy.add(1, 2);
			System.out.println("--->" + resultadd);
			
			int resultdiv = proxy.div(4, 2);
			System.out.println("--->" +resultdiv);
			
			
	}

}
