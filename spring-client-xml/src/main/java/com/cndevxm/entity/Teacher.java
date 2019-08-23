package com.cndevxm.entity;

import com.cndevxm.annotation.qualifiers.BMWCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("王老师")
public class Teacher {

	// 姓名
	private String name;
	// 年纪
	private int age;
	// 学科
	private String subject;
	// 房子
	private House house;
	// 车子
	@Autowired
	@BMWCar(value = "bmw3")
	private Car car;

	public Teacher() {
	}

	public Teacher(String name, int age, String subject, House house, Car car) {
		this.name = name;
		this.age = age;
		this.subject = subject;
		this.house = house;
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

//	public void init(){
//		System.out.println("调用了初始化方法");
//	}
//
//	public void des() {
//		System.out.println("调用了销毁方法");
//	}

	@Override
	public String toString() {
		return "Teacher{" +
				"name='" + name + '\'' +
				", age=" + age +
				", subject='" + subject + '\'' +
				", house=" + house +
				", car=" + car +
				'}';
	}
}
