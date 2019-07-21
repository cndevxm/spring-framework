package com.cndevxm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLClient {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");

		// 普通bean
		System.out.println(applicationContext.getBean("teacher"));
		// 静态内部类bean
		System.out.println(applicationContext.getBean("chineseTeacher"));
		System.out.println(applicationContext.getBean("cTeacher"));
		// 静态工厂方法
		System.out.println(applicationContext.getBean("entityStaticFactoryTeacher"));
		// 实例工厂方法
		System.out.println(applicationContext.getBean("entityFactory"));
		System.out.println(applicationContext.getBean("entityFactoryTeacher"));


		// 通过构造器注入
		System.out.println("constructTeacher1：" + applicationContext.getBean("constructTeacher1").toString());
		// 通过setter注入
		System.out.println(applicationContext.getBean("constructTeacher2").toString());
		// 静态工厂构造器注入
		System.out.println(applicationContext.getBean("entityStaticFactoryTeacher1").toString());
		// 实例工厂构造器注入
//		System.out.println(applicationContext.getBean("entityFactoryTeacher1").toString());


	}
}
