package com.kang.spring.bean.factory;

public class Car {

	private String brand;
	private String price;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
		System.out.println("����" + this.brand);
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
		System.out.println("����" + this.price);
	}
	public void init()
	{
		System.out.println("��ʼ������");
	}
	
	public void destory()
	{
		System.out.println("���ٷ�����");
	}
	public Car() {
		super();
		System.out.println("���췽����");
	}
	public Car(String brand, String price) {
			this.brand = brand;
			this.price = price;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + "]";
	}
	
}