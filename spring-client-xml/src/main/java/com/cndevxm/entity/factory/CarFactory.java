package com.cndevxm.entity.factory;

import com.cndevxm.entity.Car;

public class CarFactory {

	public Car createBuickCar() {
		return new Car("别克", "car");
	}

}
