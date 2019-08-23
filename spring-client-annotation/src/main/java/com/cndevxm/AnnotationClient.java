package com.cndevxm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于注解启动的application
 */
public class AnnotationClient {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		// profile
		applicationContext.getEnvironment().setActiveProfiles("dev");
		applicationContext.refresh();

		// 通过容器获取bean
		System.out.println(applicationContext.getBean("gc").toString());
		System.out.println(applicationContext.getBean("bungalow").toString());

		System.out.println(applicationContext.getBean("house").toString());
		System.out.println(applicationContext.getBean("teacher").toString());


		applicationContext.registerShutdownHook();

	}
}
