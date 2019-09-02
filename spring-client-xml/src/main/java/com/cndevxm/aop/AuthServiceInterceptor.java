package com.cndevxm.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AuthServiceInterceptor implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		System.out.println("执行了AuthServiceInterceptor的前置通知...");

		Object result = invocation.proceed();

		System.out.println("执行了AuthServiceInterceptor的后置通知...");

		return result;
	}
}
