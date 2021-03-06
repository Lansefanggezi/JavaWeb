package com.systop.reflectTest;

import java.lang.reflect.Field;

public class ReflectTest {
	private String fname;
	private String lname;
	
	//定义ReflectTest类的构造方法
	public ReflectTest(String fname, String lname)
	{
		this.fname = fname;
		this.lname = lname;
	}

	public static void main(String[] args) {
		try {
			// 创建ReflectTest对象，同时初始化对象的属性
			ReflectTest reflect = new ReflectTest("jack","saas");
			
			fun(reflect);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//静态方法
	public static void fun(Object obj) throws IllegalArgumentException, IllegalAccessException
	{
		//获取obg.getClass()类的所有成员变量列表，存放再fleds数组里
		Field[] fields = obj.getClass().getDeclaredFields();
		System.out.println("替换之前的");
		
		//对fields数组中的值进行迭代
		for(Field field : fields)
		{
			//打印field中当前存放的obj对象的属性名和属性值
			System.out.println("名：" + field.getName() + "  value:" +field.get(obj));
			
			//此处必须设置为true才可以修改成员变量
			field.setAccessible(true);
			
			String org = (String) field.get(obj);
			field.set(obj, org.replaceAll("a", "b"));
		}
		System.out.println("替换之后：");
		for(Field field: fields)
		{
			System.out.println("名：" + field.getName() + "   value:" +field.get(obj));
		}
	}
}
