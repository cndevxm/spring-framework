package com.cndevxm.aop.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;

public class ServiceAspect {

	/**
	 * demo():切入点签名方法
	 * execution：切入点指示器
	 * * demo(..)：切入点表达式
	 */
	@Pointcut("execution(* demo(..))")
	private void demo() {

	}

	// befor
	public void doBefore() {
		System.out.println("执行了前置通知...");
	}

	// after returning
	public void doAfterReturning() {
		System.out.println("执行了正常返回通知...");
	}

	// after throwing
	public void doAfterThrowing() {
		System.out.println("执行了异常返回通知...");
	}

	// around
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("执行环绕处理前通知...");
		String result = "";
		try {
			result = (String) joinPoint.proceed();

			if ("校验通过".equals(result)) {
				result = "true";
			} else {
				result = "false";
			}
		} catch (Throwable throwable) {
			System.out.println(throwable.getMessage());
			System.out.println("执行环绕抛出异常通知通知...");
			throw throwable;
		} finally {
			System.out.println("执行环绕处理后通知...");
		}
		return result;
	}

	// after
	public void doAfter() {
		System.out.println("执行了后置通知...");
	}
}
