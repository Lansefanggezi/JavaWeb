package com.kang.spring.helloworld;

public class HelloWorld {

	private String name;
	
	public void setName(String name)
	{
		System.out.println("����set�Űl");
		this.name = name;
	}
	public void  hello()
	{
		System.out.println("hello" + name);
	}
	public HelloWorld()
	{
	System.out.println("��ǰ���д˘��췽��");	
	}
}
