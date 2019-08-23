package com.cndevxm.entity.factory;

import com.cndevxm.entity.House;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class HouseFactory {

	// bean的别名 只支持这一种方式
	@Bean(name = {"highRise", "gc"})
	public House highRise() {
		House house = new House();
		house.setType("highRise");
		return house;
	}

	@Bean(name = {"bungalow", "yf"})
	public House bungalow() {
		House house = new House();
		house.setType("bungalow");
		return house;
	}

}
