package com.systop.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.systop.bean.Person;

public class TestSpring {

	public static void mian(String[] args)
	{
		//����Spring����
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//��ȡChineseImplʵ��������
		Person personChinese = (Person)context.getBean("Chinese");
		
		//Chinese˵��
		personChinese.Speak();
		
		//��ȡAmericanImplʵ��������
		Person personAmerican = (Person)context.getBean("American");
		
		//American˵��
		personAmerican.Speak();
	}
}