package com.cndevxm.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Bus extends Car implements InitializingBean, DisposableBean {

	private String busName;

	public Bus() {

	}

	public Bus(String busName) {
		this.busName = busName;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}


//	public void init() {
//		System.out.println("进行了基于XML的初始化方法");
//	}
//
//	public void des(){
//		System.out.println("进行了基于XML的销毁方法");
//	}


	@PostConstruct
	public void postConstruct() {
		System.out.println("进行了基于@PostConstruct的初始化方法");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("进行了基于@PreDestroy的销毁方法");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("调用了afterPropertiesSet方法");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("调用了destroy方法");
	}


	@Override
	public String toString() {
		return "Bus{" +
				"busName='" + busName + '\'' +
				"} " + super.toString();
	}
}
