package com.cndevxm.entity;

public class Department {

	// 名称
	private String name;
	// 级别
	private String level;

	private Car car;

	private Bus bus;

	public Department() {
	}

	public Department(String name, String level, Car car, Bus bus) {
		this.name = name;
		this.level = level;
		this.car = car;
		this.bus = bus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "Department{" +
				"name='" + name + '\'' +
				", level=" + level +
				", car=" + car +
				", bus=" + bus +
				'}';
	}

	public Bus createBus() {
		return null;
	}
}
