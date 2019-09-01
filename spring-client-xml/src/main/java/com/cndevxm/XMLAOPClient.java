package com.cndevxm;

import com.cndevxm.aop.InDto;
import com.cndevxm.aop.IntroductionService;
import com.cndevxm.service.AuthService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于XML配置的application
 */
public class XMLAOPClient {

	public static void main(String[] args) {

		// 基于类路径的xml文件配置
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-aop.xml");

		AuthService authService = (AuthService) applicationContext.getBean("authService");
		System.out.println("执行登陆操作************************");
		System.out.println(authService.login("123", "123"));
		System.out.println("执行登出操作************************");
		System.out.println(authService.logout("123"));
		System.out.println("执行登陆操作************************");
		System.out.println(authService.login(new InDto("123", "12")));

		System.out.println("加解密操作************************");
		((IntroductionService) authService).decrypt("");

	}
}