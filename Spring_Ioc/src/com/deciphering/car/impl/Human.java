package com.deciphering.car.impl;

import com.deciphering.car.Car;

public class Human {

	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	//����
	public void run()
	{
		car.run();
	}
}
