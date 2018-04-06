package com.kang.spring.bean.factooryBean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Car> {

	private String brand;
	
	private String price;
	
		@Override
		public Car getObject() throws Exception {
			return new Car(brand,price);
		}
	
		@Override
		public Class<?> getObjectType() {
			// TODO Auto-generated method stub
			return Car.class;
		}
	
		@Override
		public boolean isSingleton() {
			// TODO Auto-generated method stub
			return true;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

}
