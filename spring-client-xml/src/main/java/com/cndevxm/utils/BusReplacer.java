package com.cndevxm.utils;

import com.cndevxm.entity.Bus;
import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class BusReplacer implements MethodReplacer {

	/**
	 * @param obj    被替换的对象
	 * @param method 被替换的方法名
	 * @param args   被替换的方法参数
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		// 这里不能调用原先的方法，原先的方法已经被替换，会重新进入到这个方法当中，形成死循环

		return new Bus("182");
	}
}
