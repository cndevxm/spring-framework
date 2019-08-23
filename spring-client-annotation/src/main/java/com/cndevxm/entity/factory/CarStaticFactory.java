package com.cndevxm.entity.factory;

import com.cndevxm.entity.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CarStaticFactory {

	@Bean("ford")
	public static Car createFordCar() {
		return new Car("福特", "car");
	}

}
