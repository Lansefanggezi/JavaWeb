package com.kang.spring.helloworld;

public class HelloWorld {

	private String name;
	
	public void setName(String name)
	{
		System.out.println("執行set放發");
		this.name = name;
	}
	public void  hello()
	{
		System.out.println("hello" + name);
	}
	public HelloWorld()
	{
	System.out.println("當前執行此構造方法");	
	}
}
