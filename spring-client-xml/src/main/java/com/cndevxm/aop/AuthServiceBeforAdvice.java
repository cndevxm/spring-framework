package com.cndevxm.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class AuthServiceBeforAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("执行了AuthBeforAdvice...");
	}
}
