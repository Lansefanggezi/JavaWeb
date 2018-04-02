package com.systop.bean;

public class AmericanImpl implements Person {

	//名字
	private String name;
	
	//年龄
	private int age;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public void Speak() {
		System.out.println("我是："+ getName() + "我的年龄是："+ getAge());

	}

}
