package com.cndevxm.entity;

public class Dog {

	// 品种
	private String variety;

	private int age;

	private String coat;

	public Dog() {
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCoat() {
		return coat;
	}

	public void setCoat(String coat) {
		this.coat = coat;
	}

	@Override
	public String toString() {
		return "Dog{" +
				"variety='" + variety + '\'' +
				", age=" + age +
				", coat='" + coat + '\'' +
				'}';
	}
}
