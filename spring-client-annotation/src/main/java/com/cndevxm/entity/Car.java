package com.cndevxm.entity;

import org.springframework.stereotype.Component;

@Component("ncar")
public class Car {

	// 品牌
	private String brand;

	// 风格 car business suv
	private String style;

	public Car() {

	}

	public Car(String brand, String style) {
		this.brand = brand;
		this.style = style;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Override
	public String toString() {
		return "Car{" +
				"brand='" + brand + '\'' +
				", style='" + style + '\'' +
				'}';
	}

	// 内部静态类bean
	@Component("oldCar")
	static class OldCar extends Car {

		private String name;

		public OldCar() {
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "OldCar{" +
					"name='" + name + '\'' +
					"} " + super.toString();
		}
	}

}
