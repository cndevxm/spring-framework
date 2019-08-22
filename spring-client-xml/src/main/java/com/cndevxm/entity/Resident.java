package com.cndevxm.entity;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * 房子居住者
 */
@Component
public class Resident {

	private String name;
	private String idcard;
	private boolean sex;

	@Inject
	private Car car;


	public Resident() {
	}


	public Resident(Car car) {
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Lookup(value = "bus")
	public Bus getBus() {
		return null;
	}

	@Override
	public String toString() {
		return "Resident{" +
				"name='" + name + '\'' +
				", idcard='" + idcard + '\'' +
				", sex=" + sex +
				", car=" + car +
				'}';
	}
}
