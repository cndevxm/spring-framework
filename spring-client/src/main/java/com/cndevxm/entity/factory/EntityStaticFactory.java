package com.cndevxm.entity.factory;

import com.cndevxm.entity.Account;
import com.cndevxm.entity.Car;
import com.cndevxm.entity.House;
import com.cndevxm.entity.Teacher;

public class EntityStaticFactory {

	public static Teacher createTeacher() {
		return new Teacher();
	}

	public static Teacher createTeacher(String name, int age, House house, Car firstCar, Car secondCar, Account account) {
		return new Teacher(name, age, house, firstCar, secondCar, account);
	}

	public static Teacher createTeacher(String name, int age, House house, Car firstCar, Account account, Car secondCar) {
		return new Teacher(name, age, house, firstCar, secondCar, account);
	}

	public static Teacher createTeacher(String name, House house, Account account, Car firstCar, Car secondCar, int age) {
		return new Teacher(name, age, house, firstCar, secondCar, account);
	}

	public static Teacher createTeacher(House house, Account account, Car firstCar, Car secondCar, int age, String name) {
		return new Teacher(name, age, house, firstCar, secondCar, account);
	}

	public static Teacher createTeacher(House house, Account account, Car firstCar, int age, String name, Car secondCar) {
		return new Teacher(name, age, house, firstCar, secondCar, account);
	}

	public static Teacher createTeacher(Account account, House house, Car firstCar, int age, String name, Car secondCar) {
		return new Teacher(name, age, house, firstCar, secondCar, account);
	}


}
