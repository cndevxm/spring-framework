package com.cndevxm.aop.reflectDemo;

import java.lang.reflect.Proxy;

public class TestForumService {

	public static void main(String[] args) {

		//①希望被代理的目标业务类
		ForumService target = new ForumServiceImpl();

		//②将目标业务类和横切代码编织到一起
		PerformanceHandler performanceHandler = new PerformanceHandler(target);

		//③根据编织了目标业务类逻辑和性能监视横切逻辑的InvocationHandler实例创建代理实例
		ForumService proxyClass = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), performanceHandler);

		//④调用代理实例
		proxyClass.removeTopic(10);
		proxyClass.removeForum(1000);

		System.out.println("美丽的分割线*************************");

		CglibProxy cglibProxy = new CglibProxy();
		ForumServiceImpl forumService = (ForumServiceImpl) cglibProxy.getProxy(ForumServiceImpl.class);
		proxyClass.removeTopic(10);
		proxyClass.removeForum(1000);

		// 动态代理过程
		// 1、创建编织器
		//  jdk动态代理通过实现InvocationHandler的invoke方法将业务方法与横切逻辑织在一起，因为jdk的动态代理是基于公共接口实现的，所以代理类并不知道目标业务类的业务方法实现，所以需要通过目标业务类完成业务方法的调用
		//  cglib代理通过实现MethodInterceptor的intercept方法将业务方法与横切逻辑织在一起，因为它是基于子类的，所以它不需要实际的目标业务类对象
		// 2、创建代理对象
		//  jdk动态代理通过Proxy的newProxyInstance方法创建代理对象，它不在乎目标业务类是啥，只在乎目标业务类的接口
		//  cglib通过Enhancer对象创建代理对象

		/**
		 * 我们虽然通过PerformanceHandler或CglibProxy实现了性能监视横切逻辑的动态织入，但这种实现方式存在三个明显需要改进的地方：
		 *
		 * 1）目标类的所有方法都添加了性能监视横切逻辑，而有时，这并不是我们所期望的，我们可能只希望对业务类中的某些特定方法添加横切逻辑；
		 * 2）我们通过硬编码的方式指定了织入横切逻辑的织入点，即在目标类业务方法的开始和结束前织入代码；
		 * 3）我们手工编写代理实例的创建过程，为不同类创建代理时，需要分别编写相应的创建代码，无法做到通用。
		 *
		 * 以上三个问题，在AOP中占用重要的地位，因为Spring AOP的主要工作就是围绕以上三点展开：Spring AOP通过Pointcut（切点）指定在哪些类的哪些方法上织入横切逻辑，通过Advice（增强）描述横切逻辑和方法的具体织入点（方法前、方法后、方法的两端等）。此外，Spring通过Advisor（切面）将Pointcut和Advice两者组装起来。有了Advisor的信息，Spring就可以利用JDK或CGLib的动态代理技术采用统一的方式为目标Bean创建织入切面的代理对象了。
		 *
		 * JDK动态代理所创建的代理对象，在JDK 1.3下，性能强差人意。虽然在高版本的JDK中，动态代理对象的性能得到了很大的提高，但是有研究表明，CGLib所创建的动态代理对象的性能依旧比JDK的所创建的代理对象的性能高不少（大概10倍）。但CGLib在创建代理对象时所花费的时间却比JDK动态代理多（大概8倍），所以对于singleton的代理对象或者具有实例池的代理，因为无须频繁创建代理对象，所以比较适合用CGLib动态代理技术，反之适合用JDK动态代理技术。值得一提的是，由于CGLib采用动态创建子类的方式生成代理对象，所以不能对目标类中的final方法进行代理。
		 */
	}
}
