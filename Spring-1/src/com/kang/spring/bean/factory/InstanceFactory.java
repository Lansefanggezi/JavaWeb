package com.kang.spring.bean.factory;

import java.util.HashMap;
import java.util.Map;

public class InstanceFactory {

	private Map<String, Car> cars = new HashMap<>();
	
	public InstanceFactory()
	{
		cars.put("aodi", new Car("aodi","3000"));
		cars.put("baoma", new Car("baoma","4000"));
	}
	
	public Car getCar(String key)
	{
		return cars.get(key);
	}
}
