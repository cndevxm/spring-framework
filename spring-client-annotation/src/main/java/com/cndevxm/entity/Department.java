package com.cndevxm.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Department {

	// 名称
	@Value("河南分公司")
	private String name;
	// 级别
	@Value("2")
	private String level;

	private Car car;

	@Autowired
	@Qualifier("182")
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

	@Lookup("182")
	public Bus createBus() {
		return null;
	}
}
