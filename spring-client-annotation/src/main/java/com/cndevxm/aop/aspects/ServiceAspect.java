package com.cndevxm.aop.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceAspect {

	/**
	 * demo():切入点签名方法
	 * execution：切入点指示器
	 * * demo(..)：切入点表达式
	 */
	@Pointcut("execution(* demo(..))")
	private void demo() {
	}


	@Before("bean(authService)")
	public void doBefore() {
		System.out.println("执行了前置通知...");
	}

	@AfterReturning("bean(authService)")
	public void doAfterReturning() {
		System.out.println("执行了正常返回通知...");
	}

	@AfterThrowing("bean(authService)")
	public void doAfterThrowing() {
		System.out.println("执行了异常返回通知...");
	}

	@Around("bean(authService)")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("执行环绕处理前通知");
		String result = "";
		try {
			result = (String) joinPoint.proceed();

			if ("校验通过".equals(result)) {
				result = "true";
			} else {
				result = "false";
			}
			return result;
		} catch (Throwable throwable) {
			System.out.println(throwable.getMessage());
			System.out.println("执行环绕抛出异常通知通知...");
			throw throwable;
		} finally {
			System.out.println("执行环绕处理后通知...");
		}

	}

	@After("bean(authService)")
	public void doAfter() {
		System.out.println("执行了后置通知...");
	}
}
