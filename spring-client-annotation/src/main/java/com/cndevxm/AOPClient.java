package com.cndevxm;

import com.cndevxm.service.AuthService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于注解启动的application
 */
public class AOPClient {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPConfig.class);


		AuthService authService = (AuthService) applicationContext.getBean("authService");
		System.out.println(authService.login("123", ""));


		applicationContext.registerShutdownHook();

	}
}
