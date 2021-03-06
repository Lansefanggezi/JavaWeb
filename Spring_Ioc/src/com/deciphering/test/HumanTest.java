package com.deciphering.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jdom.JDOMException;
import org.junit.Test;

import com.deciphering.car.Car;
import com.deciphering.car.impl.Human;
import com.deciphering.spring.ClassPathXmlApplicationContextCarl;

public class HumanTest {


	@Test
	public void test() throws InstantiationException, IllegalAccessException, ClassNotFoundException, JDOMException, IOException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		ClassPathXmlApplicationContextCarl context = new ClassPathXmlApplicationContextCarl();
		Human human = (Human)context.getBean("human");
		Car car = (Car)context.getBean("car");
		//human.setCar(car);
		human.run();
	}

}
