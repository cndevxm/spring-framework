package com.cndevxm;

import com.cndevxm.entity.Bus;
import com.cndevxm.entity.Department;
import com.cndevxm.eventAndListener.BusEvent;
import com.cndevxm.eventAndListener.Publisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Locale;

/**
 * 基于注解启动的application
 */
public class AnnotationClient {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		// profile
		applicationContext.getEnvironment().setActiveProfiles("test");
		applicationContext.refresh();

		// 通过容器获取bean
		System.out.println(applicationContext.getBean("gc").toString());
		System.out.println(applicationContext.getBean("bungalow").toString());

		System.out.println(applicationContext.getBean("house").toString());
		System.out.println(applicationContext.getBean("teacher").toString());

		// @Lookup
		Department department = (Department) applicationContext.getBean("department");
		Bus bus1 = department.createBus();
		Bus bus2 = department.createBus();
		System.out.println(bus1 == bus2);

		//profile
		System.out.println(applicationContext.getBean("company").toString());

		// propertySource
		System.out.println(applicationContext.getEnvironment().getProperty("jdbc.driver"));
		System.out.println(applicationContext.getEnvironment().getProperty("jdbc.url"));
		System.out.println(applicationContext.getEnvironment().getProperty("jdbc.username"));
		System.out.println(applicationContext.getEnvironment().getProperty("jdbc.password"));

		// messageSource
		System.out.println(applicationContext.getMessage("w", null, Locale.US));
		System.out.println(applicationContext.getMessage("w", null, Locale.SIMPLIFIED_CHINESE));
		System.out.println(applicationContext.getMessage("w", null, Locale.getDefault()));
		System.out.println(applicationContext.getMessage("w", null, null));
		System.out.println(applicationContext.getMessage("ss", new Object[]{"张三", "坑"}, null));

		// event and listener
		// TODO 遗留问题 通过注解的配置异步无法生效
		Publisher publisher = (Publisher) applicationContext.getBean("publisher");
		BusEvent busEvent = new BusEvent();
		busEvent.setBusName("182");
		busEvent.setEventType("出发");
		busEvent.setDate(new Date());
		publisher.publish(busEvent);

		BusEvent busEvent1 = new BusEvent();
		busEvent1.setBusName("B28");
		busEvent1.setEventType("出发");
		busEvent1.setDate(new Date());
		publisher.publish(busEvent1);

		// propertyEditor
		System.out.println(applicationContext.getBean("company").toString());

		// spel
		// TODO 遗留问题无法获取系统属性
		System.out.println(applicationContext.getBean("spelDemo").toString());





		applicationContext.registerShutdownHook();

	}
}
