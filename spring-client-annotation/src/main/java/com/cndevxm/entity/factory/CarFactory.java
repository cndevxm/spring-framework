package com.cndevxm.entity.factory;

import com.cndevxm.entity.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CarFactory {

	@Bean("buick")
	public Car createBuickCar() {
		return new Car("别克", "car");
	}

	@Bean(name = "amg")
	public Car creatAmg() {
		Car car = new Car();
		car.setBrand("benz");
		car.setStyle("car");
		return car;
	}

	@Bean(name = "v")
	public Car creatV() {
		Car car = new Car();
		car.setBrand("benz");
		car.setStyle("business");
		return car;
	}

	@Bean(name = "bwm3")
	public Car creatBWM3() {
		Car car = new Car();
		car.setBrand("bmw");
		car.setStyle("car");
		return car;
	}

	@Bean(name = "bwm5")
	@Primary
	public Car creatBWM5() {
		Car car = new Car();
		car.setBrand("bmw");
		car.setStyle("car");
		return car;
	}

	@Bean(name = "bwm7")
	@Lazy
	public Car creatBWM7() {
		Car car = new Car();
		car.setBrand("bmw");
		car.setStyle("car");
		return car;
	}


}
