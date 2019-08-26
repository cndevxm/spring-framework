package com.cndevxm.entity;

public class Company {

	// 名称
	private String name;
	// 部门
	private Department department;

	private Dog dog;

	private Cat cat;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "Company{" +
				"name='" + name + '\'' +
				", department=" + department +
				", dog=" + dog +
				", cat=" + cat +
				'}';
	}
}
