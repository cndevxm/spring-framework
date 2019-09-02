package com.cndevxm.aop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("authServiceBeforAdvice")
public class AuthServiceBeforAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("执行了AuthBeforAdvice...");
	}
}
