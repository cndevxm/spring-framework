package com.cndevxm.entity;

public class Company {

	// 名称
	private String name;
	// 部门
	private Department department;

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

	@Override
	public String toString() {
		return "Company{" +
				"name='" + name + '\'' +
				", department=" + department +
				'}';
	}
}
