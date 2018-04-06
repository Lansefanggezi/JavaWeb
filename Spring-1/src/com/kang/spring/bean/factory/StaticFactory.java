package com.kang.spring.bean.factory;

import java.util.HashMap;
import java.util.Map;

/*
 * 静态工厂方法 ： 直接调用某个类的静态方法返回实例
 * */
public class StaticFactory {

	private static Map<String, Car> cars = new HashMap<>();
	
	//静态代码块
	static
	{
		cars.put("aodi",new Car("aodi","2000"));
		cars.put("baoma",new Car("baoma","4000"));
	}
	
	public static Car getCar(String key)
	{
		return cars.get(key);
	}
}
