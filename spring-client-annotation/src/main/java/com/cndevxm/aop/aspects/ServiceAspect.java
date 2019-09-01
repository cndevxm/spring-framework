package com.cndevxm.aop.aspects;


import com.cndevxm.aop.IntroductionService;
import com.cndevxm.aop.IntroductionServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceAspect {

	// 引入增强
	@DeclareParents(value = "com.cndevxm.service.impl.*", defaultImpl = IntroductionServiceImpl.class)
	public IntroductionService introductionService;

	/**
	 * demo():切入点签名方法
	 * execution：切入点指示器
	 * * demo(..)：切入点表达式
	 */
	@Pointcut("execution(* demo(..))")
	private void demo() {
	}

	// 配置切入点
//	@Pointcut("execution(* com.cndevxm.service.AuthService.login(..))")
//	@Pointcut("within(com.cndevxm.service..*)")
//	@Pointcut("this(com.cndevxm.service.AuthService)")
//	@Pointcut("target(com.cndevxm.service.AuthService)")
//	@Pointcut("args(java.lang.String)")

//	@Pointcut("@args(com.cndevxm.aop.annotation.Mark)")
//	@Pointcut("@target(com.cndevxm.aop.annotation.Mark)")
//	@Pointcut("@within(com.cndevxm.aop.annotation.Mark)")
//	@Pointcut("@annotation(com.cndevxm.aop.annotation.Mark)")

//	@Pointcut("bean(authService)")

	// TODO 遗留问题 introdection 无法触发其他通知
//	@Pointcut("this(com.cndevxm.aop.IntroductionService)")
	@Pointcut("target(com.cndevxm.aop.IntroductionService)")
	private void authPointcut() {

	}


	@Before("authPointcut()")
	public void doBefore() {
		System.out.println("执行了前置通知...");
	}

	@AfterReturning("authPointcut()")
	public void doAfterReturning() {
		System.out.println("执行了正常返回通知...");
	}

	@AfterThrowing("authPointcut()")
	public void doAfterThrowing() {
		System.out.println("执行了异常返回通知...");
	}

	@Around("authPointcut()")
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
			System.out.println("执行环绕抛出异常通知...");
			throw throwable;
		} finally {
			System.out.println("执行环绕处理后通知...");
		}
		return result;
	}

	@After("authPointcut()")
	public void doAfter() {
		System.out.println("执行了后置通知...");
	}
}
