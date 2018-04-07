package com.kang.spring.bean.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.PessimisticLockingFailureException;

import com.kang.spring.bean.autowire.Person;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("relation-bean.xml");
		
		Person person = (Person) context.getBean("person");
		Person personfather = (Person)context.getBean("personfather");
		System.out.println(person.toString());
		System.out.println(personfather.toString());
		
		System.out.println(person == personfather);

		Person san = (Person) context.getBean("personsan");
		System.out.println(san.toString());
	}

}
