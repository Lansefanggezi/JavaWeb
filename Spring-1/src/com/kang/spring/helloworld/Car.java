package com.kang.spring.helloworld;

public class Car {

	private String brand;
	private String corp;
	private double  price;
	private int  maxSpeed;
	
	//������һ
	public Car(String brand, String corp, Double price) {
		super();
		this.brand = brand;
		this.corp = corp;
		this.price = price;
	}

	//�������� �����б�ͬ����Ͳ�ͬ
	public Car(String brand, String corp, int maxSpeed) {
		super();
		this.brand = brand;
		this.corp = corp;
		this.maxSpeed = maxSpeed;
	}


	@Override
	public String toString() {
		return "Car [brand=" + brand + ", corp=" + corp + ", price=" + price + ", maxSpeed=" + maxSpeed + "]";
	}
	
	
}
