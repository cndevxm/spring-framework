package com.cndevxm.entity.factory;

import com.cndevxm.entity.Car;
import com.cndevxm.entity.House;
import com.cndevxm.entity.Teacher;

public class TracherFactory {

	public Teacher createMathTeacher(String name, int age, String subject, House house, Car car) {
		return new Teacher(name, age, subject, house, car);
	}
}
