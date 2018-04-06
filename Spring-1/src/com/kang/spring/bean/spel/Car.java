package com.kang.spring.bean.spel;

public class Car {

	private String name;
	
	private double price;
	
	//车的轮胎宽度
	private int  width;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + ", width=" + width + "]";
	}
	public Car() {
		System.out.println("car 构造方法");
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	
}
