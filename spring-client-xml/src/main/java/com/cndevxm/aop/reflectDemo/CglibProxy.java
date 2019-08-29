package com.cndevxm.aop.reflectDemo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class clazz) {
		//① 设置需要创建子类的类
		enhancer.setSuperclass(clazz);
		// 在此处绑定intercept方法
		enhancer.setCallback(this);
		//②通过字节码技术动态创建子类实例
		return enhancer.create();
	}

	@Override
	//③拦截父类所有方法的调用
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		PerformanceMonitor.begin(obj.getClass().getName() + "," + method.getName());
		Object result = proxy.invokeSuper(obj, args);
		PerformanceMonitor.end();
		return result;
	}
}
