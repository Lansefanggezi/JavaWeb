package com.deciphering.car.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class TestCar {

	@Test
	public void test() {
		Human human = new Human();
		BMWCar car = new BMWCar();
		human.setCar(car);
		human.run();
	}

}
