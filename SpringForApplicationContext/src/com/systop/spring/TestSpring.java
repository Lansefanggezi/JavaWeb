package com.systop.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.systop.bean.Person;

public class TestSpring {

	public static void mian(String[] args)
	{
		//创建Spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//获取ChineseImpl实例的引用
		Person personChinese = (Person)context.getBean("Chinese");
		
		//Chinese说话
		personChinese.Speak();
		
		//获取AmericanImpl实例的引用
		Person personAmerican = (Person)context.getBean("American");
		
		//American说话
		personAmerican.Speak();
	}
}
