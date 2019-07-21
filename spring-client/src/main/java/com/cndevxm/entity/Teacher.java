package com.cndevxm.entity;

import java.beans.ConstructorProperties;

public class Teacher {

	private String name;
	private int age;
	private House house;
	private Car firstCar;
	private Car secondCar;
	private Account account;

	public Teacher() {
		System.out.println("调用了默认的构造函数");
	}

	@ConstructorProperties({"", "", "", "fC", "sC", ""})
	public Teacher(String name, int age, House house, Car firstCar, Car secondCar, Account account) {
		this.name = name;
		this.age = age;
		this.house = house;
		this.firstCar = firstCar;
		this.secondCar = secondCar;
		this.account = account;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getFirstCar() {
		return firstCar;
	}

	public void setFirstCar(Car firstCar) {
		this.firstCar = firstCar;
	}

	public Car getSecondCar() {
		return secondCar;
	}

	public void setSecondCar(Car secondCar) {
		this.secondCar = secondCar;
	}

	public static class ChineseTeacher {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	@Override
	public String toString() {
		return "Teacher{" +
				"name='" + name + '\'' +
				", age=" + age +
				", house=" + house +
				", firstCar=" + firstCar +
				", secondCar=" + secondCar +
				", account=" + account +
				'}';
	}
}
