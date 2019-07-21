package com.cndevxm.entity;

public class Car {

	private String brand;

	public Car() {
		System.out.println("调用了car的无参构造函数");
	}

	public Car(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Car{" +
				"brand='" + brand + '\'' +
				'}';
	}
}
