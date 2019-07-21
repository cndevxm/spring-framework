package com.cndevxm.entity.factory;

import com.cndevxm.entity.Account;
import com.cndevxm.entity.Car;
import com.cndevxm.entity.House;
import com.cndevxm.entity.Teacher;

public class EntityFactory {

	public Teacher createTeacher() {
		return new Teacher();
	}

	public Teacher createTeacher(House house, Account account, Car firstCar, Car secondCar, int age, String name) {
		return new Teacher(name, age, house, firstCar, secondCar, account);
	}

	public Teacher createTeacher(String name, int age, House house, Car firstCar, Car secondCar, Account account) {
		return new Teacher(name, age, house, firstCar, secondCar, account);
	}

}
