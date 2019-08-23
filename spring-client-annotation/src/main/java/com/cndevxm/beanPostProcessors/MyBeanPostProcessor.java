package com.cndevxm.beanPostProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + "进入了MyBeanPostProcesser的postProcessBeforeInitialization方法...");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + "进入了MyBeanPostProcesser的postProcessAfterInitialization方法...");
		return null;
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
