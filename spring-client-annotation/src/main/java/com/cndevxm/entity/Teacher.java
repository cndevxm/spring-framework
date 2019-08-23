package com.cndevxm.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
public class Teacher {

	// 姓名
	@Value("朱老师")
	private String name;
	// 年纪
	@Value("25")
	private int age;
	// 学科
	@Value("math")
	private String subject;
	// 房子
	@Resource
	private House house;
	// 车子
	@Autowired
	@Qualifier("bwm7")
	private Car car;

	public Teacher() {
	}

	@PostConstruct
	public void init() {
		System.out.println("对老师进行了人道创造...");
	}

	@PreDestroy
	public void des() {
		System.out.println("对老师进行了人道毁灭...");
	}

	@Override
	public String toString() {
		return "Teacher{" +
				"name='" + name + '\'' +
				", age=" + age +
				", subject='" + subject + '\'' +
				", house=" + house +
				", car=" + car +
				'}';
	}
}
