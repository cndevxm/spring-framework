package com.cndevxm;

import com.cndevxm.aop.InDto;
import com.cndevxm.aop.IntroductionService;
import com.cndevxm.service.AuthService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于注解启动的application
 */
public class AnnotationAOPClient {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPConfig.class);

		AuthService authService = (AuthService) applicationContext.getBean("authService");
		System.out.println("执行登陆操作************************");
		System.out.println(authService.login("123", "123"));
		System.out.println("执行登出操作************************");
		System.out.println(authService.logout("123"));
		System.out.println("执行登陆操作************************");
		System.out.println(authService.login(new InDto("123", "12")));

		System.out.println("加解密操作************************");
		IntroductionService introductionService = (IntroductionService) authService;
		introductionService.decrypt("123");

		System.out.println("自定义代理对象操作************************");
		AuthService proxyAuthService = (AuthService) applicationContext.getBean("proxyAuthService");
		proxyAuthService.login("123", "123");

		System.out.println("自动代理对象操作************************");
		AuthService autoProxyAuthService = (AuthService) applicationContext.getBean("autoProxyAuthService");
		autoProxyAuthService.login("123", "123");


		applicationContext.registerShutdownHook();

	}
}
