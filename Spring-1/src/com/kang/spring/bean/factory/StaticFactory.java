package com.kang.spring.bean.factory;

import java.util.HashMap;
import java.util.Map;

/*
 * ��̬�������� �� ֱ�ӵ���ĳ����ľ�̬��������ʵ��
 * */
public class StaticFactory {

	private static Map<String, Car> cars = new HashMap<>();
	
	//��̬�����
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
