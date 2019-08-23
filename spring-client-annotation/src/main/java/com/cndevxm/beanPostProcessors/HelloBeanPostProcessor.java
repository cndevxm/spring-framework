package com.cndevxm.beanPostProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class HelloBeanPostProcessor implements BeanPostProcessor, Ordered {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("hello：" + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("bye：" + beanName);
		return bean;
	}

	@Override
	public int getOrder() {
		return -1;
	}
}
