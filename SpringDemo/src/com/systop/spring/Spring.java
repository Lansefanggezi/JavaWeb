package com.systop.spring;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.systop.bean.Person;

public class Spring {

	@Test
	public void test() {//����Spring����
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
