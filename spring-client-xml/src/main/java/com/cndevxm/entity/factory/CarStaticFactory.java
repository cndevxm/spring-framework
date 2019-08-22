package com.cndevxm.entity.factory;

import com.cndevxm.entity.Car;

public class CarStaticFactory {

	public static Car createFordCar() {
		return new Car("福特", "car");
	}

}
