package com.deciphering.car.impl;

import com.deciphering.car.Car;

public class BMWCar implements Car {

	private String MyBrand = "����";
	
	@Override
	public String getBrand() {
		// TODO Auto-generated method stub
		return MyBrand;
	}

	@Override
	public void run() {
		System.out.println(MyBrand + "�����أ�");
	}

}
