package com.cndevxm.beanPostProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class BusBPP implements BeanPostProcessor, Ordered {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("调用BusBPP的postProcessBeforeInitialization方法");
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("调用BusBPP的postProcessAfterInitialization方法");
		return null;
	}

	@Override
	public int getOrder() {
		return 0;
	}

	public BusBPP() {
		System.out.println("实例化BusBPP");
	}
}
