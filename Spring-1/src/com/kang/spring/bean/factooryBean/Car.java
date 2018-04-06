package com.kang.spring.bean.factooryBean;

public class Car {

	private String brand;
	private String price;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
		System.out.println("设置" + this.brand);
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
		System.out.println("设置" + this.price);
	}
	public void init()
	{
		System.out.println("初始化方法");
	}
	
	public void destory()
	{
		System.out.println("销毁方法。");
	}
	public Car(String brand, String price) {
		super();
		this.brand = brand;
		this.price = price;
		System.out.println("构造方法。");
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + "]";
	}
	
}
