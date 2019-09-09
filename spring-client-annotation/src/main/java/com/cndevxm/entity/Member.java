package com.cndevxm.entity;

public class Member {

	private String id;
	private String name;
	private int age;
	private String idCard;

	public Member() {
	}

	public Member(String id, String name, int age, String idCard) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.idCard = idCard;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "Member{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", idCard='" + idCard + '\'' +
				'}';
	}
}
