package com.cndevxm.beanPostProcessors;

import com.cndevxm.entity.Bus;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class BusBPP implements BeanPostProcessor, Ordered {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Bus) {
			System.out.println("调用BusBPP的postProcessBeforeInitialization方法");
		}
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Bus) {
			System.out.println("调用BusBPP的postProcessAfterInitialization方法");
		}
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
